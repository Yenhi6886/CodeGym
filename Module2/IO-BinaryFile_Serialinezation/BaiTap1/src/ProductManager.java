import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static final String FILE_PATH = "products.dat";
    private static List<Product> productList = new ArrayList<Product>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> fromFile = Product.readProductListFromFile(FILE_PATH);
        if (fromFile != null) {
            productList = fromFile;
        }

        int choice;
        do {
            System.out.println("---- MENU ----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị tất cả sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    showAllProduct();
                    break;
                case 3:
                    searchProductById(scanner);
                    break;
                case 0:
                    System.out.println("Kết thúc");
                    break;
                default:
                    System.out.println("Chọn lại");
                    break;
            }
        } while (choice != 0);
    }


    //Thêm, hiển thị, tìm kiếm
    private static void addProduct(Scanner scanner) {
        System.out.print("Mã SP: ");
        String id = scanner.nextLine();
        System.out.print("Tên SP: ");
        String name = scanner.nextLine();
        System.out.print("Giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Hãng: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Mô tả: ");
        String description = scanner.nextLine();

        Product p = new Product(id, name, price, manufacturer, description);
        productList.add(p);
        Product.writeProductListToFile(FILE_PATH, productList);
    }


    private static void showAllProduct() {
        productList = Product.readProductListFromFile(FILE_PATH);
        if (productList == null || productList.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào");
        } else {
            for (Product p : productList) {
                System.out.println(p);
            }
        }
    }

    private static void searchProductById(Scanner scanner) {
        System.out.println("Nhập mã cần tìm: ");
        String id = scanner.nextLine();
        productList = Product.readProductListFromFile(FILE_PATH);
        boolean found = false;
        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào.");
        }
    }
}
