public class BastionAbility implements Ability {
    public String getId() { return "BASTION"; }
    public int shieldOnPlay() { return 2; }
    public int bonusDamageOnPlay() { return 0; }
    public int pingDamageOnPlay() { return 0; }
    public boolean cyclesOnPlay() { return false; }
}