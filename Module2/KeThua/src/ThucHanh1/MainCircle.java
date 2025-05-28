package ThucHanh1;

public class MainCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(4);
        System.out.println(circle);
        circle = new Circle(2,"red",false);
        System.out.println(circle);
    }
}
