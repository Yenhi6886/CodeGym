package org.example;

import java.util.Scanner;

public class TriangleApp {
    public static void validateTriangle(double a, double b, double c)
            throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Canh tam giac phai lon hon 0");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tong hai canh phai lon hon canh con lai");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Nhap canh a: ");
            double a = sc.nextDouble();
            System.out.println("Nhap canh b: ");
            double b = sc.nextDouble();
            System.out.println("Nhap canh c: ");
            double c = sc.nextDouble();

            validateTriangle(a, b, c);

            System.out.println("Tam giac hop le voi cac canh: "+a+" "+b+" "+c);
        } catch(IllegalTriangleException e){
            System.err.println("Loi tam giac: "+e.getMessage());
        } catch(Exception e){
            System.err.println("Loi nhap vao");
        } finally {
            sc.close();
        }
    }
}
