package dip;

import java.util.List;

public interface SceneModel {
    void add(Shape s);
    void select(Shape s);
    List<Shape> shapes();
}
