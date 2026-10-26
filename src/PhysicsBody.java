package game;

import java.util.ArrayList;
import java.util.List;

/** Solo física: suma las fuerzas registradas y mueve la figura dentro del mundo. */
public class PhysicsBody implements Updatable {
    private final Shape shape;
    private final double mass;
    private final List<Force> forces = new ArrayList<>();
    private double vx, vy, bounce = 0.5;

    public PhysicsBody(Shape shape, double mass) {
        if (mass <= 0) throw new IllegalArgumentException("La masa debe ser > 0");
        this.shape = shape; this.mass = mass;
    }
    public double getMass() { return mass; }
    public PhysicsBody addForce(Force f) { forces.add(f); return this; }

    @Override public void update(World world) {
        double dt = 1.0 / world.fps(), ax = 0, ay = 0;
        for (Force f : forces) { double[] a = f.acceleration(this); ax += a[0]; ay += a[1]; }
        vx += ax * dt; vy += ay * dt;
        shape.setX(shape.getX() + vx * dt);
        shape.setY(shape.getY() + vy * dt);
        double floor = world.height() - shape.getHeight();
        if (shape.getY() > floor) { shape.setY(floor); vy = -vy * bounce; }
    }
}
