package srp;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Valida, parsea y modifica el modelo, sin Swing y sin reflexión (S2). */
public class ShapeEditor {
    public static final List<String> FIELDS = List.of("x", "y", "width", "height", "fillColor", "borderColor");
    private static final Map<String, Color> NAMES = Map.of("black", Color.BLACK, "white", Color.WHITE,
        "red", Color.RED, "green", Color.GREEN, "blue", Color.BLUE, "yellow", Color.YELLOW, "gray", Color.GRAY);

    public static Optional<Color> parseColor(String text) {
        String t = text.trim().toLowerCase();
        if (!t.startsWith("#")) return Optional.ofNullable(NAMES.get(t));
        try { return Optional.of(Color.decode(t)); } catch (NumberFormatException e) { return Optional.empty(); }
    }

    public String read(Shape s, String field) {
        switch (field) {
            case "x": return String.valueOf(s.getX());
            case "y": return String.valueOf(s.getY());
            case "width": return String.valueOf(s.getWidth());
            case "height": return String.valueOf(s.getHeight());
            case "fillColor": return String.format("#%06x", s.getFillColor().getRGB() & 0xFFFFFF);
            default: return String.format("#%06x", s.getBorderColor().getRGB() & 0xFFFFFF);
        }
    }

    /** @return false si el texto no es válido (la UI puede avisar). */
    public boolean apply(Shape s, String field, String text) {
        try {
            switch (field) {
                case "x": s.setX(Double.parseDouble(text)); return true;
                case "y": s.setY(Double.parseDouble(text)); return true;
                case "width": s.setWidth(Double.parseDouble(text)); return true;
                case "height": s.setHeight(Double.parseDouble(text)); return true;
                case "fillColor": parseColor(text).ifPresent(s::setFillColor); return parseColor(text).isPresent();
                case "borderColor": parseColor(text).ifPresent(s::setBorderColor); return parseColor(text).isPresent();
                default: return false;
            }
        } catch (NumberFormatException e) { return false; }
    }
}
