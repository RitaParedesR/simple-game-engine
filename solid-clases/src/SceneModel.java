package game;

import java.util.List;
import java.util.Optional;

public interface SceneModel {
    void add(Shape s);
    void select(Shape s);
    boolean isSelected(Shape s);
    List<Shape> shapes();

    /** La figura de más arriba bajo el punto, si hay alguna. */
    default Optional<Shape> pick(double x, double y) {
        List<Shape> all = shapes();
        for (int i = all.size() - 1; i >= 0; i--) if (all.get(i).contains(x, y)) return Optional.of(all.get(i));
        return Optional.empty();
    }
}
