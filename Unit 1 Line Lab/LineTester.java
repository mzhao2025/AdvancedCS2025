public class LineTester {
    public static void main(String[] args) {

        // Instantiate four Point objects
        Point p1 = new Point(2, 7);
        Point p2 = new Point(1, 4);
        Point p3 = new Point(11, 18);
        Point p4 = new Point(4, 13);

        // Instantiate a Line object using p1 and p2
        Line pointLine = new Line(p1, p2);

        // Print out the slope using both methods
        double slope1 = pointLine.calculateSlope();
        double slope2 = pointLine.calculateSlopeFromPoints(p1, p2);

        System.out.println("Using calculateSlope(): " + slope1);
        System.out.println("Using calculateSlopeFromPoints(): " + slope2);

        // Compare if both slopes are equal
        if (Math.abs(slope1 - slope2) < 1e-9) {
            System.out.println("The slopes are equal.");
        } else {
            System.out.println("The slopes are NOT equal.");
        }

        // Check if each point lies on the line
        System.out.println("Is p1 on the line? " + pointLine.isCoordinateOnLine(p1));
        System.out.println("Is p2 on the line? " + pointLine.isCoordinateOnLine(p2));
        System.out.println("Is p3 on the line? " + pointLine.isCoordinateOnLine(p3));
        System.out.println("Is p4 on the line? " + pointLine.isCoordinateOnLine(p4));
    }
}
