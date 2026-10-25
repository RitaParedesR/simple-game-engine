package isp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedHashMap;
import java.util.Map;

/** Implementa los cuatro roles; cada cliente usa solo el suyo (I3). */
public class Box implements Drawable, Updatable, Selectable, Editable {
    private double x, y, w = 64, h = 64, vy;
    private boolean selected;

    public Box(double x, double y) { this.x = x; this.y = y; }

    @Override public void draw(Graphics2D g) {
        g.setColor(Color.WHITE); g.fillRect((int) x, (int) y, (int) w, (int) h);
        g.setColor(selected ? Color.GREEN : Color.BLACK); g.drawRect((int) x, (int) y, (int) w, (int) h);
    }
    @Override public void update(double dt, double worldHeight) { vy += 9.8 * dt; y = Math.min(y + vy * dt, worldHeight - h); }
    @Override public boolean contains(double px, double py) { return px >= x && py >= y && px <= x + w && py <= y + h; }
    @Override public void setSelected(boolean selected) { this.selected = selected; }

    @Override public Map<String, String> readProperties() {
        Map<String, String> m = new LinkedHashMap<>();
        m.put("x", "" + x); m.put("y", "" + y); m.put("width", "" + w); m.put("height", "" + h);
        return m;
    }
    @Override public boolean writeProperty(String name, String value) {
        try {
            double v = Double.parseDouble(value);
            switch (name) {
                case "x": x = v; return true;
                case "y": y = v; return true;
                case "width": w = v; return true;
                case "height": h = v; return true;
                default: return false;
            }
        } catch (NumberFormatException e) { return false; }
    }
}
