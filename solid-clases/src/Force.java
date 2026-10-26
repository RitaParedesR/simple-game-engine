package game;

/** Una fuerza devuelve una aceleración {ax, ay}. Agregar viento o fricción no modifica PhysicsBody. */
@FunctionalInterface
public interface Force { double[] acceleration(PhysicsBody body); }
