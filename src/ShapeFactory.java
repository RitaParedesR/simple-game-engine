package game;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/** Registro de creadores por tipo: agregar una figura es registrar una línea, sin switch. */
public class ShapeFactory {
    public interface Creator { Shape create(double x, double y, double w, double h); }

    private static final double DEFAULT_SIZE = 64;
    private final Map<String, Creator> creators = new LinkedHashMap<>();

    public ShapeFactory register(String type, Creator c) { creators.put(type, c); return this; }
    public Set<String> types() { return Collections.unmodifiableSet(creators.keySet()); }

    public Shape create(String type, double x, double y) {
        Creator c = creators.get(type);
        if (c == null) throw new IllegalArgumentException("Figura desconocida: " + type);
        return c.create(x, y, DEFAULT_SIZE, DEFAULT_SIZE);
    }
}
