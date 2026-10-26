package ocp;

import java.awt.geom.Ellipse2D;

public class Circle extends Shape {
    public Circle(double x, double y, double w, double h) { super(x, y, w, h); }
    @Override protected java.awt.Shape outline() { return new Ellipse2D.Double(x, y, width, height); }
}
