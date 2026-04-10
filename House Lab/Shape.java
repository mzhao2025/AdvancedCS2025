import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

    protected int xCoord[];
    protected int yCoord[];
    protected Color fillColor;
    protected Color strokeColor;
    protected int strokeWidth;


    public Shape(int[] xCoord, int[] yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    abstract public double getArea();

    abstract public void draw(Graphics g);


    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public void setFillColor(int r, int g, int b) {
        this.fillColor = new Color(r, g, b);
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public void setStrokeColor(int r, int g, int b) {
        this.strokeColor = new Color(r, g, b);
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setCoordinates(int[] xCoord, int[] yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }


    public String toString() {
        return "This is a Shape.";
    }
    
}
