package game;

/** Tamaño del mundo y FPS: reemplaza Window.WINDOW_HEIGHT y el FPS estático global. */
public class World {
    private final int width, height;
    private volatile int fps;

    public World(int width, int height, int fps) { this.width = width; this.height = height; this.fps = fps; }
    public int width() { return width; }
    public int height() { return height; }
    public int fps() { return fps; }
    public void setFps(int fps) { this.fps = Math.max(1, fps); }
}
