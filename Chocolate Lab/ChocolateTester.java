public class ChocolateTester {
        // Optional local test (does NOT affect JUnit grading)
    public static void main(String[] args) {
        CocoaRegister r = new CocoaRegister();
        r.addItem(new MilkBar(45), 2);
        r.addItem(new DarkBar(45), 1);
        r.addItem(new MatchaBar(45), 1);
        r.addItem(new CocoaSticker(), 3);
        r.addItem(new TShirt(), 1);
        r.printReceipt();
    }
}
