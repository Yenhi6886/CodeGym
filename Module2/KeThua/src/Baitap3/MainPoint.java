package Baitap3;

public class MainPoint {
    public static void main(String[] args) {
        Point p = new Point();
        System.out.println(p);

        p = new Point(5.5f, 8);
        System.out.println(p);
        System.out.println("---------");

        MovablePoint p1 = new MovablePoint();
        System.out.println("Default MovablePoint: " + p1);

        p1 = new MovablePoint(5.5f, 8);
        System.out.println(p1);

        p1 = new MovablePoint(5.5f, 9, 3.4f, 5.5f);
        System.out.println(p1);

        System.out.println("After moving: " + p1.move());
    }
}
