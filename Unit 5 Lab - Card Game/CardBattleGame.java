import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardBattleGame {

    // TODO: Implement the full game.
    // Must print:
    // == CARD CLASH ==
    // Starting: Player/Bot
    // Winner: Player/Bot
    public static String playGame(ArrayList<Card> playerDeck, ArrayList<Card> botDeck, Random rng) {
        // coin flip to decide who goes first
        boolean playerStarts = rng.nextBoolean();
        PlayerState player = new PlayerState("Player", playerDeck);
        PlayerState bot = new PlayerState("Bot", botDeck);

        System.out.println("== CARD CLASH ==");
        System.out.println("Starting: " + (playerStarts ? "Player" : "Bot"));
        //   draw & play if no active card
        // - apply abilities correctly
        // - attack using type multipliers
        // - detect game over
        // - print a short log:
        while (true) {
            if (playerStarts) {
                drawAndPlayIfNeeded(player, bot);
                attackOnce(player, bot);
            } else {
                drawAndPlayIfNeeded(bot, player);
                attackOnce(bot, player);
            }
            // check for game over and print winner
            if (playerDeck.isEmpty() && player.active == null) {
                System.out.println("Winner: Bot");
                return "Bot";
            } else if (botDeck.isEmpty() && bot.active == null) {
                System.out.println("Winner: Player");
                return "Player";
            }
            playerStarts = !playerStarts;
        }
    }

    // ----- helpers you may implement or use -----

    // Draw top card if no active, apply on-play effects
    public static void drawAndPlayIfNeeded(PlayerState self, PlayerState other) {
        if (self.active == null && self.deck.size() > 0) {
            self.active = self.deck.remove(0);
            if (self.pendingDamage > 0) {
                self.active.takeDamage(self.pendingDamage);
                self.pendingDamage = 0;

                if (self.active.getToughness() <= 0) {
                    self.active = null; // it died immediately
                }
            }
        }
    }

    // One attack (self active attacks other active if both exist)
    // public static void attackOnce(PlayerState attacker, PlayerState defender) {
    //     if (attacker.active != null && defender.active != null) {
    //         int damage = attacker.active.getStrength();
    //         CardType attackerType = attacker.active.getType();
    //         CardType defenderType = defender.active.getType();

    //         // Apply type multipliers
    //         if (attackerType == CardType.GRANITE && defenderType == CardType.BLADE) {
    //             damage *= 2;
    //         } else if (attackerType == CardType.BLADE && defenderType == CardType.PARCHMENT) {
    //             damage *= 2;
    //         } else if (attackerType == CardType.PARCHMENT && defenderType == CardType.GRANITE) {
    //             damage *= 2;
    //         }

    //         // Apply damage to defender's active card
    //         defender.active.takeDamage(damage);
            
    //         // If defender's active card is destroyed, remove it
    //         if (defender.active.getToughness() <= 0) {
    //             defender.active = null;
    //         }
    //     } else if (attacker.active != null && defender.active == null) {
    //         // If defender has no active card, apply pending damage for RIPPLE
    //         defender.pendingDamage += attacker.active.getStrength();
    //     }

    // }
    public static void attackOnce(PlayerState attacker, PlayerState defender) {
        if (attacker.active == null) return;
    
        if (defender.active != null) {
            int damage = attacker.active.getStrength();
    
            CardType aType = attacker.active.getType();
            CardType dType = defender.active.getType();
    
            if (aType == CardType.GRANITE && dType == CardType.BLADE) {
                damage *= 2;
            } else if (aType == CardType.BLADE && dType == CardType.PARCHMENT) {
                damage *= 2;
            } else if (aType == CardType.PARCHMENT && dType == CardType.GRANITE) {
                damage *= 2;
            }
    
            defender.active.takeDamage(damage);
    
            if (defender.active.getToughness() <= 0) {
                defender.active = null;
            }
            return;
        }
    
        if (!defender.deck.isEmpty()) {
            int ripple = attacker.active.getStrength();
    
            CardType aType = attacker.active.getType();
            CardType nextType = defender.deck.get(0).getType(); // top card they'll draw next
    
            if (aType == CardType.GRANITE && nextType == CardType.BLADE) {
                ripple *= 2;
            } else if (aType == CardType.BLADE && nextType == CardType.PARCHMENT) {
                ripple *= 2;
            } else if (aType == CardType.PARCHMENT && nextType == CardType.GRANITE) {
                ripple *= 2;
            }
    
            defender.pendingDamage += ripple;
        }
    }

    // Optional local run (not graded)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Card> player = DecksAndChecks.buildDefaultDeck();
        ArrayList<Card> bot = BotFactory.buildBotDeck();

        if (!DecksAndChecks.isValidDeck(player)) {
            System.out.println("Player deck invalid!");
            return;
        }

        playGame(player, bot, new Random());
    }
}
