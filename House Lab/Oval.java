import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Oval extends Shape {

    private int xRadius;
    private int yRadius;

    
    public Oval(int xCoord, int yCoord, int xRadius, int yRadius){
        super(new int[]{xCoord}, new int[]{yCoord});
        this.xRadius = xRadius;
        this.yRadius = yRadius;
       
    }

    public Oval(int xRadius, int yRadius){
        this(0, 0, xRadius, yRadius);
    }

    public double getArea(){
        return Math.PI * xRadius * yRadius;
    }

    public void setCoordinates(int xCoord, int yCoord){
        this.xCoord[0] = xCoord;
        this.yCoord[0] = yCoord;
    }

    public void draw(Graphics g){

        Graphics2D g2D = (Graphics2D) g; //initializes a 2D graphics component
        g2D.setPaint(fillColor); // sets the paint color to cyan
        g.fillOval(xCoord[0], yCoord[0], xRadius, yRadius);// draws an oval filled with the paint color

        g2D.setPaint(strokeColor); // sets the paint color to blue
        g2D.setStroke(new BasicStroke(strokeWidth)); // changes the line stroke width to 5

        g.drawOval(xCoord[0], yCoord[0], xRadius, yRadius); // draws an oval outline with the paint color and stroke width
    }

    public String toString() {
        return "This shape is an Oval with a horizontal radius of " + xRadius + " a vertical radius of " + yRadius + " and an area of " + getArea() + ".";
    }
    
}
