public class Triangle extends Polygon {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        super(3);
        this.base = base;
        this.height = height;
    }

    public Triangle() {
        this(3, 4);
    }

    public double getArea() {
        return 0.5 * base * height;
    }

    public String toString() {
        return super.toString() + "It is a triangle with base "
                + base + " and height " + height + "."
                + "Its area is " + getArea() + ".";
    }

}
