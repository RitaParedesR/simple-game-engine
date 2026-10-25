package srp;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/** Solo interfaz (S2): muestra campos y delega en ShapeEditor. */
public class FeaturesPanel extends JPanel {
    private final ShapeEditor editor;
    private final Map<String, JTextField> fields = new LinkedHashMap<>();
    private Shape current;
    private boolean loading;

    public FeaturesPanel(ShapeEditor editor, Runnable onChange) {
        this.editor = editor;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (String name : ShapeEditor.FIELDS) {
            JTextField tf = new JTextField(10);
            tf.getDocument().addDocumentListener(new DocumentListener() {
                public void insertUpdate(DocumentEvent e) { changed(); }
                public void removeUpdate(DocumentEvent e) { changed(); }
                public void changedUpdate(DocumentEvent e) { changed(); }
                private void changed() {
                    if (!loading && current != null && editor.apply(current, name, tf.getText())) onChange.run();
                }
            });
            fields.put(name, tf);
            add(new JLabel(name));
            add(tf);
        }
    }

    public void show(Shape s) {
        current = s; loading = true;
        fields.forEach((name, tf) -> tf.setText(editor.read(s, name)));
        loading = false;
    }
}
