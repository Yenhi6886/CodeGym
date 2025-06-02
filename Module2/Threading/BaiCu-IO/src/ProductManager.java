import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static final String FILE_PATH = "products.dat";
    private static List<Product> productList = new ArrayList<Product>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    //Thêm san pham
    public static void addProduct(Scanner sc) {
        System.out.print("Mã SP: ");
        String id = sc.nextLine();
        System.out.print("Tên SP: ");
        String name = sc.nextLine();
        System.out.print("Giá SP: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Hàng sản xuất: ");
        String manufacturer = sc.nextLine();
        System.out.println("Mô tả: ");
        String describe = sc.nextLine();

        Product p = new Product(id, name, price, manufacturer, describe);
        productList.add(p);
        Product.writeProductListFile(FILE_PATH,productList);
    }

    //Hien thi san pham
    public static void displayProducts(Scanner sc) {
        productList = Product.readProductListFile(FILE_PATH);
        if (productList.isEmpty() || productList == null) {
            System.out.println("Chua co san pham nao");
        } else {
            for (Product p : productList) {
                System.out.println(p);
            }
        }
    }

    //Tim kiem san pham
    public static void searchProduct(Scanner sc) {
        System.out.print("Nhap ma can tim: ");
        String id = sc.nextLine();
        productList = Product.readProductListFile(FILE_PATH);
        boolean found = false;
        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(id)) {
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ma dang nhap!");
        }
    }
}
