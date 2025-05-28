package BaiTap1;

public class Cylinder extends Circle {
    private double height;
    public Cylinder() {

    }
    public Cylinder(double radius) {
        super(radius);
    }
    public Cylinder(double radius, double height, String color) {
        super(radius,color);
        this.height = height;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double  getVolumeCylinder() {
        return Math.PI*super.getRadius()*super.getRadius()*height;
    }

    @Override
    public String toString() {
        return "Cylinder: " + super.toString() + ", height=" + getHeight();
    }
}
