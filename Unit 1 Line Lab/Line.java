import java.util.Random;

public class Line {
    private int a, b, c;
    private Point p1;
    private Point p2;

    Line(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Line() {
        do {
            this.a = generateRandomParameter();
            this.b = generateRandomParameter();
        } while (a == 0 && b == 0);
        this.c = generateRandomParameter();
    }

    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        // instance variables a, b, and c
        // a = - (y2 - y1)
        this.a = -(p2.getY() - p1.getY()); 

        // b = x2 - x1
        this.b = p2.getX() - p1.getX(); 

        // c = - (a * x1 + b * y1)
        this.c = -(this.a * p1.getX() + p1.getY() * this.b); 
    }

    public int generateRandomParameter() {
        Random rand = new Random();
        return rand.nextInt(21) - 10;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public Point getP1() {
	    return p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP1(Point p1) {
	    this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public double calculateSlope() {
        if (b == 0) {
            throw new ArithmeticException("Slope is undefined for vertical lines");
        }
        return -((double) a / b);
    }

    public boolean isCoordinateOnLine(Point p) {
        return (a * p.getX() + b * p.getY() + c) == 0;
    }

    public double calculateSlopeFromPoints(Point p1, Point p2) {
        if (p2.getX() - p1.getX() == 0) {
            throw new ArithmeticException("Slope is undefined for vertical lines");
        }
        return (double) (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    }

    public String generatePointSlopeFormula() {
        return "(y - " + p1.getY() + ") = " + calculateSlope() + "(x - " + p1.getX() + ")";
    }

    public String toString() {
        return "Line: " + a + "x + " + b + "y + " + c + " = 0";
    }

    public boolean equals(Line other) {
        return this.a == other.a && this.b == other.b && this.c == other.c;
    }

    public String isParallelTo(Line other) {
        if (this.b == 0 && other.b == 0) {
            return "The lines are parallel (both vertical)";
        } else if (this.calculateSlope() == other.calculateSlope()) {
            return "These lines are parallel";
        }

        int det = this.a * other.b - other.a * this.b; // determinant
        if (det == 0) {
            return "The lines are coincident (infinite intersections)";
        }

        double x = (double)(this.b * other.c - other.b * this.c) / det;
        double y = (double)(this.c * other.a - other.c * this.a) / det;

        return "The lines intersect at (" + x + ", " + y + ")";
    }

}
