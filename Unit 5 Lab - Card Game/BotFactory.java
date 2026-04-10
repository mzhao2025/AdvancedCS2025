import java.util.ArrayList;

public class BotFactory {

    // Bot has 5 base cards, all 3/3, no abilities
    public static ArrayList<Card> buildBotDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        deck.add(new NamedCard("Bot-1", CardType.GRANITE, 3, 3, false, false, false));
        deck.add(new NamedCard("Bot-2", CardType.PARCHMENT, 3, 3, false, false, false));
        deck.add(new NamedCard("Bot-3", CardType.BLADE, 3, 3, false, false, false));
        deck.add(new NamedCard("Bot-4", CardType.GRANITE, 3, 3, false, false, false));
        deck.add(new NamedCard("Bot-5", CardType.BLADE, 3, 3, false, false, false));
        return deck;
    }
}