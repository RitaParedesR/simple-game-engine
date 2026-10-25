package dip;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Box implements Shape {
    private final double x, size = 64;
    private double y, vy;

    public Box(double x, double y) { this.x = x; this.y = y; }

    @Override public void draw(Graphics2D g) {
        g.setColor(Color.WHITE); g.fill(bounds());
        g.setColor(Color.BLACK); g.draw(bounds());
    }
    @Override public void update(WorldConfig world) {
        double dt = 1.0 / world.fps();
        vy += 9.8 * dt;
        y = Math.min(y + vy * dt, world.height() - size);       // antes: Window.WINDOW_HEIGHT (D2)
    }
    @Override public Rectangle2D bounds() { return new Rectangle2D.Double(x, y, size, size); }
}
