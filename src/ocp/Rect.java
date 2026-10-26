package ocp;

import java.awt.geom.Rectangle2D;

public class Rect extends Shape {
    public Rect(double x, double y, double w, double h) { super(x, y, w, h); }
    @Override protected java.awt.Shape outline() { return new Rectangle2D.Double(x, y, width, height); }
}
