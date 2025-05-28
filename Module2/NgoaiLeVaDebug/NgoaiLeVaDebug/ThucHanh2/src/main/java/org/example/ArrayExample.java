package org.example;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createArray() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
        }
        return arr;
    }

    public void printArray(Integer[] arr) {
        System.out.println("Mảng các phần tử: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        ArrayExample example = new ArrayExample();
        Integer[] arr = example.createArray();

        example.printArray(arr);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chỉ số bât kỳ: ");
        int x = scanner.nextInt();
        try {
            System.out.println("Chỉ số "+x+" có phần tử là: "+arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Xảy ra lỗi ngoại lệ");
        }
    }
}
