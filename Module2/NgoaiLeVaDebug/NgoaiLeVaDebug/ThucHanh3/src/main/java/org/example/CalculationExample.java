package org.example;

import java.util.Scanner;

public class CalculationExample {
   private void calculate(int x, int y) {
       try {
           int a = x + y;
           int b = x - y;
           int c = x * y;
           int d = x / y;
           System.out.println(a);
           System.out.println(b);
           System.out.println(c);
           System.out.println(d);
       } catch (Exception e) {
           System.err.println("Xảy ra lỗi ngoại lệ: "+e.getMessage());
       }
   }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập x: ");
        int x = scanner.nextInt();
        System.out.println("Nhâp y: ");
        int y = scanner.nextInt();

        CalculationExample calc = new CalculationExample();
        calc.calculate(x, y);
    }
}
