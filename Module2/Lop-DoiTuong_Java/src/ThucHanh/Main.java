package ThucHanh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the width: ");
        double width = sc.nextDouble();
        System.out.println("Enter the height: ");
        double height = sc.nextDouble();

        Rectangle r = new Rectangle(width, height);
        System.out.println("Your rectangle \n" + r.display());
        System.out.println("Perimeter of the Rectangle: "+ r.getPerimeter());
        System.out.println("Area of the Rectangle: "+ r.getArea());
    }
}
