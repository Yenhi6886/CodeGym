import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài danh sách: ");
        int size = sc.nextInt();

        int[] list = new int[size];
        System.out.println("Nhận được " + list.length + " giá trị");
        for (int i = 0; i < list.length; i++) {
            list[i] = sc.nextInt();
        }
        System.out.println("Hiển thị danh sách: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("Bắt đầu xủ lí sắp xếp...");
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true; //Cần lượt lặp tiếp theo
        for (int j = 1; j < list.length && needNextPass; j++) {
            needNextPass = false;
            for (int i = 0; i < list.length - j; i++) {
                if (list[i] > list[i + 1]) {
                    System.out.println("Tráo đổi " + list[i] + " cùng với " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
            if (needNextPass == false) {
                System.out.println("Mảng đã được sắp xếp mà không cần duyệt kế tiếp");
                break;
            }
            System.out.println("Danh sách sau " + j + " sắp xếp: ");
            for (int k = 0; k < list.length; k++) {
                System.out.println(list[k] + "\t");
            }
            System.out.println();
        }
    }
}
