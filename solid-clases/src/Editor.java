package game;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/** Lógica de la aplicación. Depende solo de abstracciones (SceneModel, Consumer); las fuerzas se inyectan (gravedad, viento...). */
public class Editor {
    private final SceneModel scene;
    private final Consumer<Shape> onSelect;
    private final Force[] forces;
    private final List<Updatable> updatables = new CopyOnWriteArrayList<>();

    public Editor(SceneModel scene, Consumer<Shape> onSelect, Force... forces) {
        this.scene = scene; this.onSelect = onSelect; this.forces = forces;
    }

    /** Agrega una figura ya creada a la escena, la selecciona y le da física. */
    public Shape drop(Shape s) {
        scene.add(s);
        scene.select(s);
        PhysicsBody body = new PhysicsBody(s, 1.0);
        for (Force f : forces) body.addForce(f);
        updatables.add(body);
        onSelect.accept(s);
        return s;
    }

    public void tick(World world) { updatables.forEach(u -> u.update(world)); }
}
