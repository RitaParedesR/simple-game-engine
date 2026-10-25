package srp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/** Solo figuras y selección (S1, S3). */
public class SelectionModel {
    private final List<Shape> shapes = new ArrayList<>();
    private Shape current;

    public void add(Shape s) { shapes.add(s); current = s; }
    public void select(Shape s) { current = s; }
    public boolean isSelected(Shape s) { return s == current; }
    public List<Shape> shapes() { return Collections.unmodifiableList(shapes); }

    public Optional<Shape> pick(double px, double py) {
        for (int i = shapes.size() - 1; i >= 0; i--)
            if (shapes.get(i).contains(px, py)) return Optional.of(shapes.get(i));
        return Optional.empty();
    }
}
