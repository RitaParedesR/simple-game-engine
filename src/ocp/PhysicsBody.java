package ocp;

import java.util.ArrayList;
import java.util.List;

/** Cerrado a modificación: el comportamiento nuevo entra como Force (O3). */
public class PhysicsBody {
    private final Shape shape;
    private final double mass;
    private final List<Force> forces = new ArrayList<>();
    private double vx, vy, bounce = 0.5;

    public PhysicsBody(Shape shape, double mass) {
        if (mass <= 0) throw new IllegalArgumentException("masa > 0");
        this.shape = shape; this.mass = mass;
    }
    public double getMass() { return mass; }
    public void addForce(Force f) { forces.add(f); }

    public void step(double dt, double worldHeight) {
        double ax = 0, ay = 0;
        for (Force f : forces) { double[] a = f.acceleration(this); ax += a[0]; ay += a[1]; }
        vx += ax * dt; vy += ay * dt;
        shape.setX(shape.getX() + vx * dt);
        shape.setY(shape.getY() + vy * dt);
        if (shape.getY() + shape.getHeight() > worldHeight) {
            shape.setY(worldHeight - shape.getHeight());
            vy = -vy * bounce;
        }
    }
}
