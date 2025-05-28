package BaiTap1;

public class MainCylinder {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(5);
        System.out.println(cylinder);

        cylinder = new Cylinder(5,9,"black");
        System.out.println(cylinder);

    }
}
