package BaiTap1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhap a,b,c
        System.out.print("Nhap a: ");
        double a = sc.nextDouble();
        System.out.print("Nhap b: ");
        double b = sc.nextDouble();
        System.out.print("Nhap c: ");
        double c = sc.nextDouble();

        QuadraticEquation q = new QuadraticEquation(a, b, c);
        double delta = q.getDiscriminant();
        System.out.println("Delta: " + delta);

        //Kiem tra va xuat
        if (delta > 0) {
            System.out.println("Phương trình có 2 nghiệm:");
            System.out.println("Nghiệm 1: " + q.getRoot1());
            System.out.println("Nghiệm 2: " + q.getRoot2());
        } else if (delta == 0) {
            System.out.println("Phương trình có 1 nghiệm kép: " + q.getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
