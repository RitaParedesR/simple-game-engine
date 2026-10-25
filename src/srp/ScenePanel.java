package srp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.JPanel;

/** Solo pinta y avisa del clic (S3). */
public class ScenePanel extends JPanel {
    private final SelectionModel selection;
    private final ShapeRenderer renderer;

    public ScenePanel(SelectionModel selection, ShapeRenderer renderer, Consumer<Shape> onSelect) {
        this.selection = selection; this.renderer = renderer;
        setBackground(new Color(210, 210, 210));
        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                selection.pick(e.getX(), e.getY()).ifPresent(s -> { selection.select(s); onSelect.accept(s); repaint(); });
            }
        });
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : selection.shapes()) renderer.draw((Graphics2D) g, s, selection.isSelected(s));
    }
}
