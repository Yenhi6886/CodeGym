package BaiTap2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("A");
        s1.setClasses("C03");
        s1.display();

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten: ");
        String ten = sc.nextLine();
        s1.setName(ten);
        System.out.print("Nhap lop: ");
        String lop = sc.nextLine();
        s1.setClasses(lop);
        s1.display();
    }
}
