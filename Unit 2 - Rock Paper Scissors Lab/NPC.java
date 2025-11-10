public class NPC {
    private String choice;

    public NPC() {
        this.choice = RPSGame.generateRandomChoice();
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        choice = choice.toLowerCase();
        if (RPSGame.validateChoice(choice)) {
            this.choice = choice;
        } else {
            this.choice = RPSGame.generateRandomChoice();
        }
    }

    public String toString() {
        return "Opponent chose " + choice + ".";
    }
}
