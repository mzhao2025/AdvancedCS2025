import java.util.ArrayList;

public class RectangleTester {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(4, 5);
        Rectangle rect2 = new Rectangle();

        System.out.println(rect1.toString());
        System.out.println(rect2.toString());

        rect1.newLength(6);
        rect1.newWidth(8);

        rect2.newLength(24);
        rect2.newWidth(7);

        System.out.println(rect1.toString());
        System.out.println(rect2.toString());

        System.out.println(rect1.equals(rect2));

        System.out.println(rect1.getDiagonal());
        System.out.println(rect2.getDiagonal());
        
        int r1length = rect1.getLength();
        int r1width = rect1.getWidth();

        int[][] rotatedPoints = rect1.rotate90(0, 0, r1length, r1width, 0, 0, 18);
        for (int i = 0; i < rotatedPoints.length; i++) {
            System.out.print("[");
            for (int j = 0; j < rotatedPoints[i].length; j++) {
                System.out.print(rotatedPoints[i][j]);
                if (j < rotatedPoints[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
