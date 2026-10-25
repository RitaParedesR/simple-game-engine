package dip;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ClasspathIconProvider implements IconProvider {
    @Override public Icon load(String name) {
        URL url = getClass().getResource("/icons/" + name + ".png");
        return url == null ? new ImageIcon() : new ImageIcon(url);
    }
}
