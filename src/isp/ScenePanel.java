package isp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;

/** No implementa MouseListener: solo el clic que necesita (I2). Exige Drawable y Selectable, nada más (I3). */
public class ScenePanel<T extends Drawable & Selectable> extends JPanel {
    private final List<T> items;
    private final Renderer renderer = new Renderer();

    public ScenePanel(List<T> items) {
        this.items = items;
        setBackground(new Color(210, 210, 210));
        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                for (int i = items.size() - 1; i >= 0; i--) {
                    if (!items.get(i).contains(e.getX(), e.getY())) continue;
                    items.forEach(it -> it.setSelected(false));
                    items.get(i).setSelected(true);
                    repaint();
                    return;
                }
            }
        });
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderer.render((Graphics2D) g, items);
    }
}
