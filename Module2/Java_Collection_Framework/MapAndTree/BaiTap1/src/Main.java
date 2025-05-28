import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm theo ID");
            System.out.println("3. Xoá sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    pm.addProduct();
                    break;
                case 2:
                    pm.editProductById();
                    break;
                case 3:
                    pm.removeProductById();
                    break;
                case 4:
                    pm.displayProducts();
                    break;
                case 5:
                    pm.searchProductByName();
                    break;
                case 6:
                    pm.sortByPriceAsc();
                    break;
                case 7:
                    pm.sortByPriceDesc();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Chọn sai, vui lòng chọn lại");
            }
        } while (choice != 0);
    }
}
