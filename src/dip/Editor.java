package dip;

import java.util.function.Consumer;

/** Alto nivel (D1): recibe abstracciones por constructor, ningún new de clases concretas. */
public class Editor {
    private final ShapeFactory factory;
    private final SceneModel scene;
    private final Consumer<Shape> onSelect;

    public Editor(ShapeFactory factory, SceneModel scene, Consumer<Shape> onSelect) {
        this.factory = factory; this.scene = scene; this.onSelect = onSelect;
    }
    public Shape drop(String type, double x, double y) {
        Shape s = factory.create(type, x, y);
        scene.add(s); scene.select(s); onSelect.accept(s);
        return s;
    }
    public void tick(WorldConfig world) { scene.shapes().forEach(s -> s.update(world)); }
}
