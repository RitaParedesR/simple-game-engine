package srp;

/** Solo física (S1): misma matemática que MyShape.g(). */
public class PhysicsBody {
    private final Shape shape;
    private double gravity, bounce = 50, velocity, energy;

    public PhysicsBody(Shape shape, double worldHeight, double gravity) {
        this.shape = shape;
        this.gravity = gravity;
        this.energy = worldHeight - shape.getY() - shape.getHeight();
    }

    public synchronized void step(double worldHeight, int fps) {
        if (gravity <= 0 || fps <= 0) return;
        velocity += gravity / fps;
        double nextY = shape.getY() + velocity / fps;
        if (velocity < 0 || nextY + shape.getHeight() < worldHeight) {
            shape.setY(nextY);
        } else {
            shape.setY(worldHeight - shape.getHeight());
            energy = bounce * (energy / 100);
            velocity = -(gravity * Math.sqrt(2 * energy / gravity));
        }
    }
}
