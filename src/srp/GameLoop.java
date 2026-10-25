package srp;

import java.util.function.IntSupplier;

/** Solo temporización (S3): bucle iterativo, sin recursión. */
public class GameLoop {
    private Thread thread;

    public synchronized void start(Runnable tick, IntSupplier fps) {
        if (thread != null && thread.isAlive()) return;
        thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                long t0 = System.currentTimeMillis();
                tick.run();
                try { Thread.sleep(Math.max(0, 1000 / Math.max(1, fps.getAsInt()) - (System.currentTimeMillis() - t0))); }
                catch (InterruptedException e) { return; }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
    public synchronized void stop() { if (thread != null) thread.interrupt(); }
}
