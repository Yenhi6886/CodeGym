package BaiTap1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        circle1.display();
        Circle circle2 = new Circle(5);
        circle2.display();

        //Hoac co the cho nguoi dung nhap vao
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ban kinh: ");
        double n = sc.nextDouble();
        Circle circle3 = new Circle(n);
        circle3.display();

    }
}
