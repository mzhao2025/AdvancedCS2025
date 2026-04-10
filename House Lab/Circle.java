public class Circle extends Oval {

    
    public Circle(int xCoord, int yCoord, int radius){
        super(xCoord, yCoord, radius, radius);
       
    }

    public Circle(int radius){
        this(0, 0, radius);
    }


    public String toString() {
        return super.toString() + "This shape is also a Circle.";
    }
    
}
