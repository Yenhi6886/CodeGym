import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<Product>();
    private Scanner scanner = new Scanner(System.in);

    //THem san pham
    public void addProduct() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phầm");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(id, name, price);
        products.add(product);
        System.out.println("Đã thêm sản phẩm");
    }

    //Sua san pham
    public void editProduct() {
        System.out.println("Nhập id cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(Product product : products) {
            if(product.getId() == id) {
                System.out.println("Tên sản phẩm: ");
                product.setName(scanner.nextLine());
                System.out.println("Giá sản phẩm");
                product.setPrice(Double.parseDouble(scanner.nextLine()));
                break;
            }
        }
        System.out.println("Không tìm thấy id");
    }

    //Xóa sản phẩm
    public void deleteProduct() {
        System.out.println("Nhập id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(Product product : products) {
            if(product.getId() == id) {
                products.remove(product);
                break;
            }
        }
        System.out.println("Không tìm thấy id");
    }

    //Hiển thị danh sách
    public void displayProduct() {
        if(products.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for(Product product : products) {
                System.out.println(product);
            }
        }
    }

    //Tim theo tên sản phẩm
    public void searchProductByName() {
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        boolean found = false;
        for(Product product : products) {
            if(product.getName().toLowerCase().equals(name)) {
                System.out.println(product);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Khong thay ten san pham muon tim");
        }
    }

    //Xep gia tang dan
    public void sortProductByDesc() {

    }
}
