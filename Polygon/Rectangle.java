public class Rectangle extends Polygon {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super(4);
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this(3, 4);
    }

    public double getArea() {
        return width * height;
    }

    public String toString() {
        return super.toString() + "It is a rectangle with width "
                + width + " and height " + height + "."
                + "Its area is " + getArea() + ".";
    }
}