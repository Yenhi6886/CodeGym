import java.util.Scanner;

public class CaiDatSapXepChen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng: ");
        int size = sc.nextInt();
        int[] list = new int[size];

        System.out.println("Nhập giá trị phần tử");
        for (int i = 0; i < list.length; i++) {
            System.out.println("Phẩn tử thứ " + (i + 1) + ": ");
            list[i] = sc.nextInt();
        }
        insertionSort(list);
        System.out.println("Phần tử sau khi sắp xép tăng dần: ");
        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i]+" ");
        }
    }

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int j;
            for (j = i - 1; j >= 0 && currentElement < list[j]; j--) {
                list[j+1] = list[j];
            }
            list[j+1] = currentElement;
        }
    }
}
