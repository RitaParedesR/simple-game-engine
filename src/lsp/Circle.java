package lsp;

import java.awt.geom.Ellipse2D;

public class Circle extends Shape {
    public Circle(double x, double y, double w, double h) { super(x, y, w, h); }
    /** Antes: Math.PI * getWidth(). */
    @Override public double area() { return Math.PI * getWidth() * getHeight() / 4; }
    @Override protected java.awt.Shape outline() { return new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight()); }
}
