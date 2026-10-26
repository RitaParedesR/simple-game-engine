package lsp;

import java.awt.geom.Path2D;

/** Polígono real: área por la fórmula del topógrafo y contorno desde sus vértices (L2). */
public abstract class PolygonShape extends Shape {
    protected PolygonShape(double x, double y, double w, double h) { super(x, y, w, h); }

    /** @return {x0,y0,x1,y1,...} */
    protected abstract double[] vertices();

    @Override public double area() {
        double[] v = vertices(); int n = v.length / 2; double sum = 0;
        for (int i = 0; i < n; i++) { int j = (i + 1) % n; sum += v[2 * i] * v[2 * j + 1] - v[2 * j] * v[2 * i + 1]; }
        return Math.abs(sum) / 2;
    }
    @Override protected java.awt.Shape outline() {
        double[] v = vertices(); Path2D p = new Path2D.Double();
        p.moveTo(v[0], v[1]);
        for (int i = 1; i < v.length / 2; i++) p.lineTo(v[2 * i], v[2 * i + 1]);
        p.closePath();
        return p;
    }
}
