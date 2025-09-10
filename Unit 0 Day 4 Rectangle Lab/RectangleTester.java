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
    }
}
