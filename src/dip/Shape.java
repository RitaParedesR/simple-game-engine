package dip;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public interface Shape {
    void draw(Graphics2D g);
    void update(WorldConfig world);
    Rectangle2D bounds();
    default boolean contains(double x, double y) { return bounds().contains(x, y); }
}
