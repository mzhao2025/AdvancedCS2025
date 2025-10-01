import java.util.Random;

public class Line {
    int a, b, c;

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

    public double calculateSlope() {
        if (b == 0) {
            throw new ArithmeticException("Slope is undefined for vertical lines");
        }
        return -((double) a / b);
    }

    public boolean isCoordinateOnLine(int x, int y) {
        return (a * x + b * y + c) == 0;
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
