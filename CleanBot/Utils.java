public class Utils {
    public static void main(String[] args) {
        Home home1 = new Home("456 Maple Ave", "      Alice     Johnson  ", 8);
        System.out.println(home1.toString());
        home1.setCleanlinessLevel(-3);
    }
}
