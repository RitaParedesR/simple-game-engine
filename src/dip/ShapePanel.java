package dip;

import java.util.List;
import java.util.function.IntConsumer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/** Recibe IconProvider y un callback de FPS; ya no escribe MainPanel.FPS (D3). */
public class ShapePanel extends JPanel {
    public ShapePanel(IconProvider icons, List<String> types, IntConsumer onFpsChange) {
        add(new JLabel("SHAPES"));
        types.forEach(t -> add(new JLabel(icons.load(t))));
        JSlider slider = new JSlider(5, 80, 25);
        slider.addChangeListener(e -> onFpsChange.accept(slider.getValue()));
        add(slider);
    }
}
