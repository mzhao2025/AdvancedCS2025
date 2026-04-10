public abstract class Card {

    private final CardType type;
    private final int strength;
    private int toughness;

    // ability flags (for deck rule checks)
    private final boolean bastion;
    private final boolean ripple;
    private final boolean cleave;

    // modifiers applied when card is played
    private int shield;
    private int bonusDamage;

    public Card(CardType type, int strength, int toughness, boolean bastion, boolean ripple, boolean cleave) {
        this.type = type;
        this.strength = strength;
        this.toughness = toughness;
        this.bastion = bastion;
        this.ripple = ripple;
        this.cleave = cleave;

        this.shield = 0;
        this.bonusDamage = 0;
    }

    // required abstract method
    public abstract String getName();

    // getters
    public CardType getType() { return type; }
    public int getStrength() { return strength; }
    public int getToughness() { return toughness; }

    public boolean hasBastion() { return bastion; }
    public boolean hasRipple() { return ripple; }
    public boolean hasCleave() { return cleave; }

    public int getShield() { return shield; }
    public int getBonusDamage() { return bonusDamage; }

    public int abilityCount() {
        int count = 0;
        if (bastion) count++;
        if (ripple) count++;
        if (cleave) count++;
        return count;
    }

    public Ability resolvedAbility() {
        if (abilityCount() != 1) return AbilityLibrary.NONE;
        if (bastion) return AbilityLibrary.BASTION;
        if (ripple) return AbilityLibrary.RIPPLE;
        return AbilityLibrary.CLEAVE;
    }

    // applies only self-buffs; other effects handled by the game
    public void applySelfOnPlay(Ability a) {
        shield += a.shieldOnPlay();
        bonusDamage += a.bonusDamageOnPlay();
    }

    // combat
    public boolean isDefeated() {
        return toughness <= 0;
    }

    public void takeDamage(int dmg) {
        if (dmg <= 0) return;

        int blocked = Math.min(shield, dmg);
        shield -= blocked;
        int remaining = dmg - blocked;

        toughness -= remaining;
    }

    public int computeDamageAgainst(Card defender) {
        int base = strength + bonusDamage;
        double mult = TypeChart.multiplier(type, defender.type);

        if (mult == 2.0) return base * 2;
        if (mult == 0.5) return (int) Math.ceil(base * 0.5);
        return base;
    }

    @Override
    public String toString() {
        return getName() + " [" + type.display() + "] "
                + strength + "/" + toughness
                + " shield=" + shield
                + " bonus=" + bonusDamage;
    }
}