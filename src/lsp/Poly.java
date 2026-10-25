package lsp;

/** Hexágono (antes se dibujaba como rectángulo). */
public class Poly extends PolygonShape {
    public Poly(double x, double y, double w, double h) { super(x, y, w, h); }
    @Override protected double[] vertices() {
        double x = getX(), y = getY(), w = getWidth(), h = getHeight();
        return new double[] { x + w / 4, y, x + 3 * w / 4, y, x + w, y + h / 2, x + 3 * w / 4, y + h, x + w / 4, y + h, x, y + h / 2 };
    }
}
