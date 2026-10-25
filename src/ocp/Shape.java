package ocp;

import java.awt.Color;
import java.awt.Graphics2D;

/** Cada figura solo declara su contorno; draw() es común. */
public abstract class Shape {
    protected double x, y, width, height;
    protected Color border = Color.BLACK, fill = Color.WHITE;

    protected Shape(double x, double y, double w, double h) { this.x = x; this.y = y; width = w; height = h; }
    public double getX() { return x; }           public void setX(double v) { x = v; }
    public double getY() { return y; }           public void setY(double v) { y = v; }
    public double getWidth() { return width; }   public void setWidth(double v) { width = v; }
    public double getHeight() { return height; } public void setHeight(double v) { height = v; }

    protected abstract java.awt.Shape outline();

    public void draw(Graphics2D g) {
        g.setColor(fill);   g.fill(outline());
        g.setColor(border); g.draw(outline());
    }
}
