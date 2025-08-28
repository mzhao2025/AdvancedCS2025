public class FRCRobot {

    private String color;
    private int cost;
    private double weight;
    private int speed;
    private String name;
    private boolean functioning;
    private int budget;

    public FRCRobot() {
        functioning = true;
        color = "Black";
        cost = 5000;
        weight = 125.5;
        speed = 10;
        name = "robotMain";
        budget = 10000;
    }

    public void takeApart() {
        System.out.println("Taking Apart Robot...");
        functioning = false;
    }
    
    public void build() {
        System.out.println("Building Robot...");
        functioning = true;
    }

    public void upgrade() {
        if (cost + 2000 > budget) {
            System.out.println("Not enough money to upgrade.");
            return;
        }
        
        System.out.println("Robot upgrading...");
        speed += 5;
        cost += 2000;
        weight += 20;
    } 

    public int getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }
 
}