import java.util.Scanner;

public class RPSGame {
    private Player player;
    private NPC opponent;

    public RPSGame(Player player, NPC opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        int tries = 0;
        while (tries < 3) {
            System.out.println("Enter your choice (rock, paper, scissors): ");
            String curLine = scan.nextLine();
            int firstSpaceIndex = curLine.indexOf(" ");
            String choice = (firstSpaceIndex == -1) ? curLine : curLine.substring(firstSpaceIndex + 1, curLine.length());
            if (validateChoice(choice)) {
                player.setChoice(choice);
                opponent.setChoice(generateRandomChoice());
                System.out.println("Player choice updated, and opponent choice was selected.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
                tries++;
            }
        }
        System.out.println("Maximum attempts reached. Generating random choice.");
        String randomChoice = generateRandomChoice();
        setPlayerValues(randomChoice, randomChoice);
        scan.close();
    }

    public boolean didPlayerWin() {
        if (player.getChoice() == opponent.getChoice()) {
            return false;
        } else if ((player.getChoice().equals("rock") && opponent.getChoice().equals("scissors")) ||
                   (player.getChoice().equals("paper") && opponent.getChoice().equals("rock")) ||
                   (player.getChoice().equals("scissors") && opponent.getChoice().equals("paper"))) {
            return true;
        } else {
            return false;
        }
    }

    public void setPlayerValues(String name, String choice) {
        player.setName(name);
        player.setChoice(choice);
    }

    public static boolean validateChoice(String choice) {
        return !(!choice.equals("rock") && !choice.equals("paper") && !choice.equals("scissors"));
    }

    public static String generateRandomChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        int index = (int) (Math.random() * 3);
        return choices[index];
    }

    public String toString() {
        if (didPlayerWin()) {
            return player.getName() + " won!\n" + "Congratulations";
        } else {
            return opponent.toString() + " won!\n" + "Better luck next time!";
        }
    }

    public String displayResults() {
        return "== GAME RESULTS ==\n"
            + player.toString() + "\n"
            + opponent.toString() + "\n"
            + this.toString();
    }
}
