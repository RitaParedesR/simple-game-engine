package dip;

@FunctionalInterface
public interface ShapeFactory { Shape create(String type, double x, double y); }
