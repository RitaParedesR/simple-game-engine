package ocp;

import java.awt.geom.Path2D;

/** Figura NUEVA: no se modifica ninguna clase existente (O1). */
public class Hexagon extends Shape {
    public Hexagon(double x, double y, double w, double h) { super(x, y, w, h); }
    @Override protected java.awt.Shape outline() {
        Path2D p = new Path2D.Double();
        p.moveTo(x + width / 4, y);
        p.lineTo(x + 3 * width / 4, y);     p.lineTo(x + width, y + height / 2);
        p.lineTo(x + 3 * width / 4, y + height); p.lineTo(x + width / 4, y + height);
        p.lineTo(x, y + height / 2);        p.closePath();
        return p;
    }
}
