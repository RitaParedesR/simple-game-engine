package ocp;

/** Una fuerza = una aceleración {ax, ay}. Agregar viento no modifica PhysicsBody (O3). */
@FunctionalInterface
public interface Force { double[] acceleration(PhysicsBody body); }
