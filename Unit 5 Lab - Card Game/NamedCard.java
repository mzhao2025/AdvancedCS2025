public class NamedCard extends Card {
    private final String name;

    public NamedCard(String name, CardType type, int strength, int toughness,
                     boolean bastion, boolean ripple, boolean cleave) {
        super(type, strength, toughness, bastion, ripple, cleave);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}