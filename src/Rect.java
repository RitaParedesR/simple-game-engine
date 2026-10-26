package game;

public class Rect extends Shape {
    public Rect(double x, double y, double w, double h) { super(x, y, w, h); }
    @Override public double area() { return getWidth() * getHeight(); }
    @Override protected java.awt.Shape outline() { return getBounds2D(); }
}
