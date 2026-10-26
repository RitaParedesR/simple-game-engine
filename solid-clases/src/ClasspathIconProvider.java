package game;

import java.net.URL;
import java.util.function.Function;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/** Carga /icons/<nombre>.png desde el classpath (sin rutas fijas de Windows). */
public class ClasspathIconProvider implements Function<String, Icon> {
    @Override public Icon apply(String name) {
        URL url = getClass().getResource("/icons/" + name + ".png");
        return url == null ? new ImageIcon() : new ImageIcon(url);
    }
}
