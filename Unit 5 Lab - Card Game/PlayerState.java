import java.util.ArrayList;

public class PlayerState {
    String name;
    ArrayList<Card> deck;
    Card active;
    int pendingDamage; // used by RIPPLE when opponent has no active card

    PlayerState(String name, ArrayList<Card> deck) {
        this.name = name;
        this.deck = deck;
        this.active = null;
        this.pendingDamage = 0;
    }

    boolean hasAnythingLeft() {
        return active != null || (deck != null && !deck.isEmpty());
    }
}