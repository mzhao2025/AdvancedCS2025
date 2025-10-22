public class TriangleLoopsTester {
    public static void main(String[] args) {
        String output = TriangleLoops.createLetterTriangleUp(3, 'A');
        System.out.println(output);
        String output2 = TriangleLoops.createLetterTriangleUp(5, 'B');
        System.out.println(output2);
        System.out.println(TriangleLoops.createLetterTriangleDown(3, 'A'));
        System.out.println(TriangleLoops.createLetterTriangleDown(5, 'B'));
        System.out.println(TriangleLoops.createNumbersTriangle(4));
    }
}
