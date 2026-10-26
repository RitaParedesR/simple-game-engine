package game;

import java.awt.Point;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/** Paleta: arrastra una figura a la escena. Recibe íconos y un callback de FPS (sin variable global). */
public class ShapePanel extends JPanel {
    public ShapePanel(Function<String, Icon> icons, Collection<String> types, IntConsumer onFpsChange,
                      BiConsumer<String, Point> onDropScreen) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("SHAPES"));
        for (String type : types) {
            JLabel l = new JLabel(type, icons.apply(type), SwingConstants.LEFT);
            DragHandler drag = new DragHandler((x, y) -> { }, (x, y) -> {
                Point p = new Point(x, y);
                SwingUtilities.convertPointToScreen(p, l);
                onDropScreen.accept(type, p);
            });
            l.addMouseListener(drag);
            l.addMouseMotionListener(drag);
            add(l);
        }
        JSlider slider = new JSlider(5, 80, 25);
        slider.addChangeListener(e -> onFpsChange.accept(slider.getValue()));
        add(slider);
    }
}
