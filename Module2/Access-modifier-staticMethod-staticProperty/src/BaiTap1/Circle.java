package BaiTap1;

public class Circle {
    private double radius=1.0;
    private String color="black";
    private double area;

    public Circle() {

    }

    public Circle(double r) {
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void display() {
        System.out.println("Dien tich hinh tron ban kinh "+getRadius()+ " mau "+getColor()+" la: " + getArea());
    }
}
