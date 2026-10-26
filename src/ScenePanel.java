package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.JPanel;

/** Solo pinta y avisa del clic (no implementa MouseListener, no usa getParent()). */
public class ScenePanel extends JPanel {
    private final SceneModel scene;

    public ScenePanel(SceneModel scene, Consumer<Shape> onSelect) {
        this.scene = scene;
        setBackground(new Color(210, 210, 210));
        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                scene.pick(e.getX(), e.getY()).ifPresent(s -> { scene.select(s); onSelect.accept(s); repaint(); });
            }
        });
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Shape s : scene.shapes()) {
            s.draw(g2);
            if (scene.isSelected(s)) { g2.setColor(Color.GREEN); g2.draw(s.getBounds2D()); }
        }
    }
}
