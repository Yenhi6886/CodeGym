import java.util.Scanner;

public class Sapxepchen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử:");
        int size = sc.nextInt();
        int[] list = new int[size];

        System.out.println("Nhập các phần tử: ");
        for(int i = 0; i < list.length; i++) {
            System.out.println("Phần thử thứ "+(i+1)+": ");
            list[i] = sc.nextInt();
        }
        System.out.println("mảng ban đầu: ");
        printArray(list);
        System.out.println();
        selectionSortByStep(list);
    }

    public static void selectionSortByStep(int[] list) {
        for(int i =1; i < list.length; i++) {
            int currentElement = list[i];
            int j;
            for(j =i-1; j >= 0 && currentElement > list[j]; j--) { //giảm dần
                list[j+1] = list[j];
            }
            list[j+1] = currentElement;
            System.out.print("Bước "+i+": ");
            printArray(list);
        }
    }

    public static void printArray(int[] list) {
        for(int j: list) {
            System.out.print(j+"\t");
        }
        System.out.println();
    }
}
