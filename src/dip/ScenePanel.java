package dip;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JPanel;

/** Avisa por callback; ya no hace ((MainPanel) getParent()) (D1). */
public class ScenePanel extends JPanel {
    private final SceneModel scene;

    public ScenePanel(SceneModel scene, Consumer<Shape> onSelect) {
        this.scene = scene;
        setBackground(new Color(210, 210, 210));
        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                List<Shape> shapes = scene.shapes();
                for (int i = shapes.size() - 1; i >= 0; i--) {
                    if (!shapes.get(i).contains(e.getX(), e.getY())) continue;
                    scene.select(shapes.get(i)); onSelect.accept(shapes.get(i)); repaint();
                    return;
                }
            }
        });
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        scene.shapes().forEach(s -> s.draw((Graphics2D) g));
    }
}
