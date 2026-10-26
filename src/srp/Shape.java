package srp;

import java.awt.Color;

/** Solo datos (S1). */
public class Shape {
    private double x, y, width, height;
    private Color borderColor = Color.BLACK, fillColor = Color.WHITE;

    public Shape(double x, double y, double width, double height) {
        this.x = x; this.y = y; this.width = width; this.height = height;
    }
    public double getX() { return x; }               public void setX(double v) { x = v; }
    public double getY() { return y; }               public void setY(double v) { y = v; }
    public double getWidth() { return width; }       public void setWidth(double v) { width = v; }
    public double getHeight() { return height; }     public void setHeight(double v) { height = v; }
    public Color getBorderColor() { return borderColor; }  public void setBorderColor(Color c) { borderColor = c; }
    public Color getFillColor() { return fillColor; }      public void setFillColor(Color c) { fillColor = c; }
    public boolean contains(double px, double py) {
        return px >= x && py >= y && px <= x + width && py <= y + height;
    }
}
