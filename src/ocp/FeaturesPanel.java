package ocp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/** Un campo por Property recibida: sin if / else if (O2). */
public class FeaturesPanel extends JPanel {
    private final List<Property> props;
    private final List<JTextField> fields = new ArrayList<>();
    private Shape current;
    private boolean loading;

    public FeaturesPanel(List<Property> props, Runnable onChange) {
        this.props = props;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (Property p : props) {
            JTextField tf = new JTextField(10);
            tf.getDocument().addDocumentListener(new DocumentListener() {
                public void insertUpdate(DocumentEvent e) { changed(); }
                public void removeUpdate(DocumentEvent e) { changed(); }
                public void changedUpdate(DocumentEvent e) { changed(); }
                private void changed() { if (!loading && current != null && p.write(current, tf.getText())) onChange.run(); }
            });
            fields.add(tf);
            add(new JLabel(p.label()));
            add(tf);
        }
    }

    public void show(Shape s) {
        current = s; loading = true;
        for (int i = 0; i < props.size(); i++) fields.get(i).setText(props.get(i).read(s));
        loading = false;
    }
}
