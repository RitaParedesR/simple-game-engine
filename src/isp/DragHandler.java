package isp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.BiConsumer;

/** Solo lo que MainPanel usa: arrastrar y soltar (I1). Sin métodos vacíos. */
public class DragHandler extends MouseAdapter {
    private final BiConsumer<Integer, Integer> onDrag, onDrop;

    public DragHandler(BiConsumer<Integer, Integer> onDrag, BiConsumer<Integer, Integer> onDrop) {
        this.onDrag = onDrag; this.onDrop = onDrop;
    }
    @Override public void mouseDragged(MouseEvent e) { onDrag.accept(e.getX(), e.getY()); }
    @Override public void mouseReleased(MouseEvent e) { onDrop.accept(e.getX(), e.getY()); }
}
