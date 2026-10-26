package lsp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JPanel;

/** Ya no sobrescribe getX/getY/getWidth/getHeight de JPanel (L3). */
public class ScenePanel extends JPanel {
    private final List<Shape> shapes;

    public ScenePanel(List<Shape> shapes) { this.shapes = shapes; setBackground(new Color(210, 210, 210)); }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) s.draw((Graphics2D) g);
    }
}
