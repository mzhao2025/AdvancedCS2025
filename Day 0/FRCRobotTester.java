public class FRCRobotTester {
    public static void main() {

        FRCRobot robotMain = new FRCRobot();
        robotMain.build();
        robotMain.upgrade();
        System.out.println("Robot Speed: " + robotMain.getSpeed());
        System.out.println("Robot Weight: " + robotMain.getWeight());
        System.out.println("Robot Cost: " + robotMain.getCost());
        robotMain.takeApart();

    }
}