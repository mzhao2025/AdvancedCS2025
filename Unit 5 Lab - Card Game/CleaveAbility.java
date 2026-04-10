public class CleaveAbility implements Ability {
    public String getId() { return "CLEAVE"; }
    public int shieldOnPlay() { return 0; }
    public int bonusDamageOnPlay() { return 2; }
    public int pingDamageOnPlay() { return 0; }
    public boolean cyclesOnPlay() { return false; }
}