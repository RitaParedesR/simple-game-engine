package game;

import java.util.function.IntSupplier;

/** Solo temporización: bucle iterativo (sin recursión) que ignora un segundo start(). */
public class GameLoop {
    private Thread thread;

    public synchronized void start(Runnable tick, IntSupplier fps) {
        if (thread != null && thread.isAlive()) return;
        thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                long t0 = System.currentTimeMillis();
                tick.run();
                long wait = 1000 / Math.max(1, fps.getAsInt()) - (System.currentTimeMillis() - t0);
                try { Thread.sleep(Math.max(0, wait)); } catch (InterruptedException e) { return; }
            }
        }, "game-loop");
        thread.setDaemon(true);
        thread.start();
    }
    public synchronized void stop() { if (thread != null) thread.interrupt(); }
}
