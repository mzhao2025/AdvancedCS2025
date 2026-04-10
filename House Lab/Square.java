public class Square extends Rectangle {

    public Square(int xCoord, int yCoord, int side) {
        super(xCoord, yCoord, side, side);
    }

    public Square(int side) {
        this(0, 0, side);
    }

    public Square() {
        super(4, 4);
    }

    public String toString() {
        return super.toString() + " This shape is also a square.";
    }
}
