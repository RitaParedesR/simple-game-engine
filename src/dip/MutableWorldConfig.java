package dip;

public class MutableWorldConfig implements WorldConfig {
    private final int width, height;
    private volatile int fps;

    public MutableWorldConfig(int width, int height, int fps) { this.width = width; this.height = height; this.fps = fps; }
    public void setFps(int fps) { this.fps = Math.max(1, fps); }
    @Override public int width() { return width; }
    @Override public int height() { return height; }
    @Override public int fps() { return fps; }
}
