package isp;

import java.awt.Graphics2D;
import java.util.Collection;

/** Depende solo de Drawable. */
public class Renderer {
    public void render(Graphics2D g, Collection<? extends Drawable> items) { items.forEach(d -> d.draw(g)); }
}
