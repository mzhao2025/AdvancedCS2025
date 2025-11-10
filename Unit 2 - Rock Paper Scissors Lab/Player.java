public class Player {
    private String name;
    private String choice;

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name + " chose " + choice + ".";
    }
}
