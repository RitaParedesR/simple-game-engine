package lsp;

public class Triangle extends PolygonShape {
    public Triangle(double x, double y, double w, double h) { super(x, y, w, h); }
    /** Antes: el vértice superior era (x + w) / 2. */
    @Override protected double[] vertices() {
        double x = getX(), y = getY(), w = getWidth(), h = getHeight();
        return new double[] { x + w / 2, y, x + w, y + h, x, y + h };
    }
}
