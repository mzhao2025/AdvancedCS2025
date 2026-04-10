import java.util.ArrayList;
import java.util.Scanner;

public class DecksAndChecks {

    // ----------------------------
    // CHECKERS (students implement)
    // ----------------------------

    // Rule: no single card may have more than 1 ability
    public static boolean checkOneAbilityPerCard(ArrayList<Card> deck) {
        for (Card deckCard : deck) {
            int abilityCount = 0;
            if (deckCard.hasBastion()) abilityCount++;
            if (deckCard.hasRipple()) abilityCount++;
            if (deckCard.hasCleave()) abilityCount++;
            if (abilityCount > 1) return false;
        }
        return true;
    }

    // Rule: no more than 3 total ability cards in the deck
    public static boolean checkNoMoreThanThreeAbilityCards(ArrayList<Card> deck) {
        int abilityCardCount = 0;
        for (Card deckCard : deck) {
            if (deckCard.hasBastion() || deckCard.hasRipple() || deckCard.hasCleave())  {
                abilityCardCount++;
            }
        }
        return abilityCardCount <= 3;
    }

    // Rule: no duplicate abilities in the deck (max one BASTION, one RIPPLE, one CLEAVE)
    public static boolean checkNoDuplicateAbilities(ArrayList<Card> deck) {
        boolean hasBastion = false;
        boolean hasRipple = false;
        boolean hasCleave = false;
        for (Card deckCard : deck) {
            if (deckCard.hasBastion()) {
                if (hasBastion) return false; // already have a card with bastion, then end
                hasBastion = true;
            }
            if (deckCard.hasRipple()) {
                if (hasRipple) return false; // already have a card with ripple, then end
                hasRipple = true;
            }
            if (deckCard.hasCleave()) {
                if (hasCleave) return false; // already have a card with cleave, then end
                hasCleave = true;
            }
        }
        return true;
    }

    // Rule: strength and toughness must be 1..5, and strength+toughness <= 6
    public static boolean checkStatsInRange(ArrayList<Card> deck) {
        for (Card deckCard : deck) {
            int strength = deckCard.getStrength();
            int toughness = deckCard.getToughness();
            if (strength < 1 || strength > 5 || toughness < 1 || toughness > 5 || strength + toughness > 6) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDeck(ArrayList<Card> deck) {
        // TODO: return true only if:
        // - deck has size 5
        // - AND all checks return true
        return deck.size() == 5 
            && checkOneAbilityPerCard(deck) 
            && checkNoMoreThanThreeAbilityCards(deck) 
            && checkNoDuplicateAbilities(deck) 
            && checkStatsInRange(deck);
    }

    // ----------------------------
    // DECK BUILDERS (students implement)
    // ----------------------------

    // Must create 5 cards, all 3/3, no abilities
    // If the user doesn't want to input a custom deck, this method should return deck
    //   of your choice for them to play with.
    public static ArrayList<Card> buildDefaultDeck() {
        ArrayList<Card> defaultDeck = new ArrayList<>(5);
        defaultDeck.add(new NamedCard("Card 1", CardType.GRANITE, 3, 3, false, false, false));
        defaultDeck.add(new NamedCard("Card 2", CardType.PARCHMENT, 3, 3, false, false, false));
        defaultDeck.add(new NamedCard("Card 3", CardType.BLADE, 3, 3, false, false, false));
        defaultDeck.add(new NamedCard("Card 4", CardType.PARCHMENT, 3, 3, false, false, false));
        defaultDeck.add(new NamedCard("Card 5", CardType.GRANITE, 3, 3, false, false, false));
        return defaultDeck;
    }

    // Prompts the user 5 times using Scanner and validates inputs.
    // Required prompt order per card:
    // name, type, strength, toughness, bastion(y/n), ripple(y/n), cleave(y/n)
    public static ArrayList<Card> buildUserDeck(Scanner sc) {
        ArrayList<Card> userDeck = new ArrayList<>(5);
        for (int i = 1; i <= 5; i++) {
            System.out.println("Card " + i + ":");

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Type (Granite, Parchment, Blade): ");
            CardType type = CardType.fromText(sc.next());
            while (type == null) {
                System.out.print("Invalid type. Enter Granite, Parchment, or Blade: ");
                type = CardType.fromText(sc.next());
            }

            System.out.print("Strength (1-5): ");
            int strength = sc.nextInt();
            while (strength < 1 || strength > 5) {
                System.out.print("Invalid strength. Enter 1-5: ");
                strength = sc.nextInt();
            }

            System.out.print("Toughness (1-5): ");
            int toughness = sc.nextInt();
            while (toughness < 1 || toughness > 5) {
                System.out.print("Invalid toughness. Enter 1-5: ");
                toughness = sc.nextInt();
            }

            while (strength + toughness > 6) {
                System.out.print("Strength + Toughness must be less than or equal to 6. Re-enter Strength: ");
                strength = sc.nextInt();
                System.out.print("Re-enter Toughness: ");
                toughness = sc.nextInt();
            }

            System.out.print("Bastion (y/n): ");
            boolean bastion = isYes(sc.next());
    
            System.out.print("Ripple (y/n): ");
            boolean ripple = isYes(sc.next());
    
            System.out.print("Cleave (y/n): ");
            boolean cleave = isYes(sc.next());

            int abilityCount = 0;
            if (bastion) abilityCount++;
            if (ripple) abilityCount++;
            if (cleave) abilityCount++;
    
            while (abilityCount > 1) {
                System.out.print("Only one ability allowed. Re-enter Bastion (y/n): ");
                bastion = isYes(sc.next());
                System.out.print("Ripple (y/n): ");
                ripple = isYes(sc.next());
                System.out.print("Cleave (y/n): ");
                cleave = isYes(sc.next());
    
                abilityCount = 0;
                if (bastion) abilityCount++;
                if (ripple) abilityCount++;
                if (cleave) abilityCount++;
            }
    
            userDeck.add(new NamedCard(name, type, strength, toughness, bastion, ripple, cleave));
        }
    
        return userDeck;
    }

    // ----------------------------
    // Optional helpers you may use
    // ----------------------------

    public static boolean isYes(String s) {
        if (s == null) return false;
        s = s.trim().toLowerCase();
        return s.equals("y") || s.equals("yes");
    }
}
