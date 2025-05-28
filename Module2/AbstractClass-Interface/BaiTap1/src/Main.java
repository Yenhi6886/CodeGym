/*
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
        System.out.println("------");

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);
        System.out.println("------");

        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);
        System.out.println("-------------");

        // Tạo mảng các đối tượng Resizeable (kiểu Shape). Shape là lớp cha
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square(3.0);
        shapes[1] = new Circle(5.8);
        shapes[2] = new Rectangle(4.5,5.7);

        Random rd = new Random();
        for (Shape sa : shapes) {
            System.out.println("--------");
            System.out.println("Truoc khi resize: ");
            System.out.println(sa);
            double percent = rd.nextInt(100) + 1;
            System.out.println("Tang kich thuoc len " + percent + "%");

            //Hình đó resize được không "có thể thay đổi kích thước" (tức là có implements Resizeable)
            if (sa instanceof Resizeable) {//Kiểm tra và ép kiểu sử dụng instanceof
                Resizeable r = (Resizeable) sa;
                if (sa instanceof Circle)
                    System.out.println("Diện tích trước: " + ((Circle) sa).getArea());
                else if (sa instanceof Rectangle)
                    System.out.println("Diện tích trước: " + ((Rectangle) sa).getArea());
                else if (sa instanceof Square)
                    System.out.println("Diện tích trước: " + ((Square) sa).getArea());

                r.resize(percent);

                if (sa instanceof Circle)
                    System.out.println("Diện tích sau: " + ((Circle) sa).getArea());
                else if (sa instanceof Rectangle)
                    System.out.println("Diện tích sau: " + ((Rectangle) sa).getArea());
                else if (sa instanceof Square)
                    System.out.println("Diện tích sau: " + ((Square) sa).getArea());
            }
        }
    }
}

*/

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Tạo mảng các đối tượng Resizeable
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new Circle(3.5);
        shapes[1] = new Rectangle(2.0, 4.0);
        shapes[2] = new Square(5.0);

        System.out.println("=== Kích thước ban đầu ===");
        for (Resizeable shape : shapes) {
            System.out.println(shape);
        }

        System.out.println("\n=== Tăng kích thước lên tỷ lệ ngẫu nhiên từ 1-100% ===");
        for (Resizeable shape : shapes) {
            double percent = random.nextInt(100) + 1;
            System.out.printf("Tăng kích thước lên %.2f%%\n", percent);
            System.out.println("Trước khi thay đổi: " + shape);

            shape.resize(percent);

            System.out.println("Sau khi thay đổi: " + shape);
            System.out.println("---------");
        }
    }
}
