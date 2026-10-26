package game;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/** Solo organiza los componentes que recibe. */
public class MainPanel extends JPanel {
    public MainPanel(JComponent palette, JComponent scene, JComponent properties) {
        super(new BorderLayout());
        add(palette, BorderLayout.WEST);
        add(scene, BorderLayout.CENTER);
        add(properties, BorderLayout.EAST);
    }
}
