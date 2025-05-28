public class Main {
    public static void main(String[] args) {
        Shape[] s = new Shape[2];
        s[0] = new Square(5.6);
        s[1] = new Square(7.9);

        for (Shape shape : s) {
            System.out.println(shape);
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
            System.out.println("-------------");
        }
    }
}
