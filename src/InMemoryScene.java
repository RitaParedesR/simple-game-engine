package game;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryScene implements SceneModel {
    private final List<Shape> shapes = new CopyOnWriteArrayList<>();
    private volatile Shape selected;

    @Override public void add(Shape s) { shapes.add(s); }
    @Override public void select(Shape s) { selected = s; }
    @Override public boolean isSelected(Shape s) { return s == selected; }
    @Override public List<Shape> shapes() { return Collections.unmodifiableList(shapes); }
}
