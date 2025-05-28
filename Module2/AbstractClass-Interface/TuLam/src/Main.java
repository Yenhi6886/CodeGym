import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rd = new Random();
        Resizeable[] size = new Resizeable[4];

        size[0] = new Circle(6.9);
        size[1] = new Rectangle(9, 7.4);
        size[2] = new Square(5.9);
        size[3] = new Square(7.6);

        System.out.println("=== Trước khi tăng kích thước ===");
        for (Resizeable resizeable : size) {
            if (resizeable instanceof Circle) {
                Circle circle = (Circle) resizeable;
                System.out.println("Circle - Radius: " + circle.getRadius() + ", Area: " + circle.getArea());
            }
            else if (resizeable instanceof Square) {
                Square square = (Square) resizeable;
                System.out.println(square); // Sử dụng toString() của Square
            }
            else if (resizeable instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) resizeable;
                System.out.println(rectangle);
            }
        }

        System.out.println("\n=== Sau khi tăng kích thước ===");
        for (Resizeable resizeable : size) {
            double percent = rd.nextInt(100) + 1;
            System.out.printf("Tăng kích thước lên %.2f%%\n", percent);
            resizeable.resize(percent);

            if (resizeable instanceof Circle) {
                Circle circle = (Circle) resizeable;
                System.out.println("Circle - Radius: " + circle.getRadius() + ", Area: " + circle.getArea());
            }
            else if (resizeable instanceof Square) {
                Square square = (Square) resizeable;
                System.out.println("square - area: "+ square.getArea()); // Sử dụng toString() của Square
            }
            else if (resizeable instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) resizeable;
                System.out.println("rectangle - area: " +rectangle.getArea());
            }

            System.out.println("=========");
        }
    }
}
