package game;

import java.awt.geom.Path2D;

/** Polígono definido por vértices en proporciones (0..1) del ancho y alto; área real por la fórmula del topógrafo. */
public class Polygon extends Shape {
    private final double[] unit;      // {x0,y0,x1,y1,...} en [0,1]

    public Polygon(double x, double y, double w, double h, double[] unit) { super(x, y, w, h); this.unit = unit.clone(); }

    public static Polygon triangle(double x, double y, double w, double h) {
        return new Polygon(x, y, w, h, new double[] { 0.5, 0, 1, 1, 0, 1 });
    }
    public static Polygon hexagon(double x, double y, double w, double h) {
        return new Polygon(x, y, w, h, new double[] { 0.25, 0, 0.75, 0, 1, 0.5, 0.75, 1, 0.25, 1, 0, 0.5 });
    }

    private double vx(int i) { return getX() + unit[2 * i] * getWidth(); }
    private double vy(int i) { return getY() + unit[2 * i + 1] * getHeight(); }

    @Override public double area() {
        int n = unit.length / 2;
        double sum = 0;
        for (int i = 0; i < n; i++) { int j = (i + 1) % n; sum += vx(i) * vy(j) - vx(j) * vy(i); }
        return Math.abs(sum) / 2;
    }
    @Override protected java.awt.Shape outline() {
        Path2D p = new Path2D.Double();
        p.moveTo(vx(0), vy(0));
        for (int i = 1; i < unit.length / 2; i++) p.lineTo(vx(i), vy(i));
        p.closePath();
        return p;
    }
}
