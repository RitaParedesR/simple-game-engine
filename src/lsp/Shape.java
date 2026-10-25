package lsp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/** Composición en vez de extends Rectangle (L1). Contrato: 0 < area() <= ancho*alto (L2). */
public abstract class Shape {
    private double x, y, width, height;
    private final Color border = Color.BLACK, fill = Color.WHITE;

    protected Shape(double x, double y, double w, double h) { this.x = x; this.y = y; width = w; height = h; }
    public double getX() { return x; }           public void setX(double v) { x = v; }
    public double getY() { return y; }           public void setY(double v) { y = v; }
    public double getWidth() { return width; }   public void setWidth(double v) { width = v; }
    public double getHeight() { return height; } public void setHeight(double v) { height = v; }

    public Rectangle2D getBounds2D() { return new Rectangle2D.Double(x, y, width, height); }
    public boolean contains(double px, double py) { return getBounds2D().contains(px, py); }

    public abstract double area();
    protected abstract java.awt.Shape outline();

    public void draw(Graphics2D g) {
        g.setColor(fill);   g.fill(outline());
        g.setColor(border); g.draw(outline());
    }
}
