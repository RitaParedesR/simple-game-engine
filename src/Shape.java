package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/** Figura con geometría propia (composición, no extiende Rectangle). Contrato: 0 < area() <= ancho * alto. */
public abstract class Shape implements Drawable, Selectable {
    private double x, y, width, height;
    private Color border = Color.BLACK, fill = Color.WHITE;

    protected Shape(double x, double y, double w, double h) { this.x = x; this.y = y; width = w; height = h; }

    public double getX() { return x; }           public void setX(double v) { x = v; }
    public double getY() { return y; }           public void setY(double v) { y = v; }
    public double getWidth() { return width; }   public void setWidth(double v) { width = v; }
    public double getHeight() { return height; } public void setHeight(double v) { height = v; }
    public Color getBorder() { return border; }  public void setBorder(Color c) { border = c; }
    public Color getFill() { return fill; }      public void setFill(Color c) { fill = c; }

    public Rectangle2D getBounds2D() { return new Rectangle2D.Double(x, y, width, height); }
    @Override public boolean contains(double px, double py) { return getBounds2D().contains(px, py); }

    public abstract double area();
    protected abstract java.awt.Shape outline();

    @Override public void draw(Graphics2D g) {
        java.awt.Shape o = outline();
        g.setColor(fill);   g.fill(o);
        g.setColor(border); g.draw(o);
    }
}
