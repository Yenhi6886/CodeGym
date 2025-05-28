import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Kiểm thử ComparableCircle
        ComparableCircle[] circles = {
                new ComparableCircle(5.0),
                new ComparableCircle(3.0),
                new ComparableCircle(7.5),
                new ComparableCircle(1.0)
        };

        System.out.println("Before sorting circles:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("\nAfter sorting circles:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        // Kiểm thử Rectangle
        Rectangle[] rectangles = {
                new Rectangle(5.0, 7.0),
                new Rectangle(3.0, 8.0),
                new Rectangle(6.0, 6.0),
                new Rectangle(2.0, 9.0)
        };

        System.out.println("\nRectangles:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        // Kiểm thử Square
        Square[] squares = {
                new Square(5.0),
                new Square(3.0),
                new Square(7.0),
                new Square(1.0)
        };

        System.out.println("\nSquares:");
        for (Square square : squares) {
            System.out.println(square);
        }
    }
}
