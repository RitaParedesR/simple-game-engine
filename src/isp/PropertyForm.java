package isp;

/** Depende solo de Editable. */
public class PropertyForm {
    public String describe(Editable e) { return e.readProperties().toString(); }
}
