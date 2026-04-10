public class RippleAbility implements Ability {
    public String getId() { return "RIPPLE"; }
    public int shieldOnPlay() { return 0; }
    public int bonusDamageOnPlay() { return 0; }
    public int pingDamageOnPlay() { return 1; }
    public boolean cyclesOnPlay() { return true; }
}