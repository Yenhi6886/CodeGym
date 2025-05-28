package org.example;

import java.util.Scanner;

public class TriangleApp {
    public static void validateTriangle(double a, double b, double c)
            throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException(
                    "Lỗi: Các cạnh tam giác phải là số dương lớn hơn 0"
            );
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException(
                    "Lỗi: Tổng 2 cạnh phải lớn hơn cạnh còn lại"
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập a: ");
            double a = sc.nextDouble();
            System.out.println("Nhập b: ");
            double b = sc.nextDouble();
            System.out.println("Nhạp c: ");
            double c = sc.nextDouble();
            validateTriangle(a, b, c);
        } catch (IllegalTriangleException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi đầu vào, cần nhập số hợp lệ");
        } finally {
            sc.close();
        }
    }

}
