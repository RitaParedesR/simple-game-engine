package isp;

import java.util.Collection;

/** Depende solo de Updatable. */
public class Simulation {
    public void tick(Collection<? extends Updatable> items, double dt, double worldHeight) {
        items.forEach(u -> u.update(dt, worldHeight));
    }
}
