package game;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ToDoubleFunction;

/** Propiedad editable: sabe leer, validar y escribir. Reemplaza el if/else if por campo (sin reflexión). */
public final class Property {
    private static final Map<String, Color> NAMES = Map.of("black", Color.BLACK, "white", Color.WHITE,
        "red", Color.RED, "green", Color.GREEN, "blue", Color.BLUE, "yellow", Color.YELLOW, "gray", Color.GRAY);

    private final String label;
    private final Function<Shape, String> reader;
    private final BiPredicate<Shape, String> writer;

    public Property(String label, Function<Shape, String> reader, BiPredicate<Shape, String> writer) {
        this.label = label; this.reader = reader; this.writer = writer;
    }
    public String label() { return label; }
    public String read(Shape s) { return reader.apply(s); }
    /** @return false si el texto no es válido (la interfaz puede avisar). */
    public boolean write(Shape s, String text) { return writer.test(s, text); }

    public static Property number(String label, ToDoubleFunction<Shape> get, ObjDoubleConsumer<Shape> set) {
        return new Property(label, s -> String.valueOf(get.applyAsDouble(s)), (s, t) -> {
            try { set.accept(s, Double.parseDouble(t.trim())); return true; } catch (NumberFormatException e) { return false; }
        });
    }

    public static Property color(String label, Function<Shape, Color> get, BiConsumer<Shape, Color> set) {
        return new Property(label, s -> String.format("#%06x", get.apply(s).getRGB() & 0xFFFFFF), (s, t) -> {
            Optional<Color> c = parseColor(t);
            c.ifPresent(v -> set.accept(s, v));
            return c.isPresent();
        });
    }

    private static Optional<Color> parseColor(String text) {
        String t = text.trim().toLowerCase();
        if (!t.startsWith("#")) return Optional.ofNullable(NAMES.get(t));
        try { return Optional.of(Color.decode(t)); } catch (NumberFormatException e) { return Optional.empty(); }
    }

    public static List<Property> defaults() {
        return List.of(
            number("X Position", Shape::getX, Shape::setX), number("Y Position", Shape::getY, Shape::setY),
            number("Shape Width", Shape::getWidth, Shape::setWidth), number("Shape Height", Shape::getHeight, Shape::setHeight),
            color("Fill Color", Shape::getFill, Shape::setFill), color("Border Color", Shape::getBorder, Shape::setBorder));
    }
}
