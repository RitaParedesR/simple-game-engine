package game;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Raíz de composición: el único lugar que elige clases concretas. */
public class Main {
    public static void main(String[] args) { SwingUtilities.invokeLater(Main::start); }

    private static void start() {
        World world = new World(600, 500, 25);
        ShapeFactory factory = new ShapeFactory().register("rectangle", Rect::new).register("circle", Circle::new)
            .register("triangle", Polygon::triangle).register("hexagon", Polygon::hexagon);
        SceneModel model = new InMemoryScene();

        ScenePanel[] scene = new ScenePanel[1];
        FeaturesPanel features = new FeaturesPanel(Property.defaults(), () -> scene[0].repaint());
        Editor editor = new Editor(model, features::show, b -> new double[] { 0, 900 });   // gravedad (px/s^2)

        scene[0] = new ScenePanel(model, features::show);
        scene[0].setPreferredSize(new Dimension(world.width(), world.height()));
        ShapePanel palette = new ShapePanel(new ClasspathIconProvider(), factory.types(), world::setFps, (type, p) -> {
            SwingUtilities.convertPointFromScreen(p, scene[0]);
            if (scene[0].contains(p)) editor.drop(factory.create(type, p.x, p.y));
        });

        JFrame f = new JFrame("Simple Game Engine (SOLID)");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new MainPanel(palette, scene[0], features));
        f.pack();
        f.setVisible(true);

        new GameLoop().start(() -> SwingUtilities.invokeLater(() -> { editor.tick(world); scene[0].repaint(); }), world::fps);
    }
}
