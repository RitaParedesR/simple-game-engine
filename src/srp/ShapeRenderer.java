package srp;

import java.awt.Color;
import java.awt.Graphics2D;

/** Solo dibujo (S1). */
public class ShapeRenderer {
    public void draw(Graphics2D g, Shape s, boolean selected) {
        g.setColor(s.getFillColor());
        g.fillRect((int) s.getX(), (int) s.getY(), (int) s.getWidth(), (int) s.getHeight());
        g.setColor(selected ? Color.GREEN : s.getBorderColor());
        g.drawRect((int) s.getX(), (int) s.getY(), (int) s.getWidth(), (int) s.getHeight());
    }
}
