package dip;

/** Raíz de composición: el único lugar que elige clases concretas (D1). */
public class Main {
    public static void main(String[] args) {
        MutableWorldConfig world = new MutableWorldConfig(800, 500, 25);
        Editor editor = new Editor((type, x, y) -> new Box(x, y), new InMemoryScene(),
                                   s -> System.out.println("seleccionada: " + s.getClass().getSimpleName()));
        Shape s = editor.drop("box", 100, 0);
        for (int i = 0; i < 100; i++) editor.tick(world);
        System.out.printf("y final = %.1f%n", s.bounds().getY());
    }
}
