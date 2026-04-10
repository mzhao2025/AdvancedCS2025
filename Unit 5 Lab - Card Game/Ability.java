public interface Ability {
    String getId();              // "BASTION", "RIPPLE", "CLEAVE", "NONE"
    int shieldOnPlay();          // shield granted when played
    int bonusDamageOnPlay();     // extra damage added to attacks
    int pingDamageOnPlay();      // damage to opponent active; if none, becomes pending
    boolean cyclesOnPlay();      // whether the card cycles itself to bottom on play
}