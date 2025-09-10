import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
        length = 1;
        width = 1;
    }

    public void newLength(int newLength) {
        length = newLength;
    }

    public void newWidth(int newWidth) {
        width = newWidth;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String toString() {
        return "Length: " + length + ", Width: " + width + ", Area: " + (length * width);
    }

    public boolean equals(Rectangle other) {
        return this.length == other.length && this.width == other.width;
    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }
    
    public double getDiagonal() {
        return Math.sqrt(length * length + width * width);
    }

    public int[][] rotate90(
        int blCornerX, int blCornerY, int length, int width, int pivotX, int pivotY, int angle) {
        int[][] rectPoints = {
            {blCornerX, blCornerY},
            {blCornerX + length, blCornerY},
            {blCornerX + length, blCornerY + width},
            {blCornerX, blCornerY + width}
        };

        int[][] rotatedPoints = new int[4][2];
        double radians = Math.toRadians(angle);


        for (int i = 0; i < 4; i++) {
            int curX = rectPoints[i][0];
            int curY = rectPoints[i][1];

            rotatedPoints[i][0] = (int) Math.round(pivotX + (curX - pivotX) 
                                    * Math.cos(radians) - (curY - pivotY) 
                                    * Math.sin(radians));
            rotatedPoints[i][1] = (int) Math.round(pivotY + (curX - pivotX) 
                                    * Math.sin(radians) + (curY - pivotY) 
                                    * Math.cos(radians));
        }

        return rotatedPoints;

    }
}
