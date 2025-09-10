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

    public int rotate90() {
        return 0;
    }
}
