public class NoneAbility implements Ability {
    public String getId() { return "NONE"; }
    public int shieldOnPlay() { return 0; }
    public int bonusDamageOnPlay() { return 0; }
    public int pingDamageOnPlay() { return 0; }
    public boolean cyclesOnPlay() { return false; }
}