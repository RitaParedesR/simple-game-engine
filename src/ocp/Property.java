package ocp;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ToDoubleFunction;

/** Una propiedad editable: reemplaza cada rama if/else if de FeaturesPanel (O2). */
public final class Property {
    private final String label;
    private final Function<Shape, String> reader;
    private final BiPredicate<Shape, String> writer;

    public Property(String label, Function<Shape, String> reader, BiPredicate<Shape, String> writer) {
        this.label = label; this.reader = reader; this.writer = writer;
    }
    public String label() { return label; }
    public String read(Shape s) { return reader.apply(s); }
    public boolean write(Shape s, String text) { return writer.test(s, text); }

    public static Property number(String label, ToDoubleFunction<Shape> get, ObjDoubleConsumer<Shape> set) {
        return new Property(label, s -> String.valueOf(get.applyAsDouble(s)), (s, t) -> {
            try { set.accept(s, Double.parseDouble(t)); return true; } catch (NumberFormatException e) { return false; }
        });
    }

    public static List<Property> defaults() {
        return List.of(number("X Position", Shape::getX, Shape::setX), number("Y Position", Shape::getY, Shape::setY),
                       number("Shape Width", Shape::getWidth, Shape::setWidth), number("Shape Height", Shape::getHeight, Shape::setHeight));
    }
}
