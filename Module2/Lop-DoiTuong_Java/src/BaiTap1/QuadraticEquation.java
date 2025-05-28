package BaiTap1;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    //Constructor
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Getter methods
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }

    //Phuong thuc tinh delta
    public double getDiscriminant() {
        return Math.pow(b,2)-4*a*c;
    }

    //Phuong thuc tinh nghiem thu nhat
    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b+Math.sqrt(delta))/(2*a);
        }
        return 0;
    }
    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b-Math.sqrt(delta))/(2*a);
        }
        return 0;
    }

}
