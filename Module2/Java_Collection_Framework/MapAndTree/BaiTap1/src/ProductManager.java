import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    //Thêm sản pham
    public void addProduct( ) {
        System.out.print("Nhap id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap ten: ");
        String ten = scanner.nextLine();
        System.out.print("Nhap gia tien: ");
        double gia = Double.parseDouble(scanner.nextLine());
        products.add(new Product(id,ten,gia));
        System.out.println("Da them san pham.");
    }

    //Sua san pham theo id
    public void editProductById(){
        System.out.print("Nhap id can sua: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(Product product : products) {
            if(product.getId() == id) {
                System.out.print("Nhap ten moi: ");
                product.setName(scanner.nextLine());
                System.out.print("Nhap gia tien: ");
                product.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Da sua san pham");
                return;
            }
        }
        System.out.println("Khong tim thay id");
    }

    //Xoa san pham theo id
    public void removeProductById() {
        System.out.print("Nhap id can xoa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(Product product : products) {
            if(product.getId() == id) {
                products.remove(product);
            }
            System.out.println("Da xoa san pham");
        }
        System.out.println("Khong tim thay id");
    }

    //Hien thi danh sach
    public void displayProducts() {
        if(products.isEmpty()) {
            System.out.println("Danh sach trong");
        } else {
            for(Product product : products) {
                System.out.println(product);
            }
        }
    }

    //Tim theo ten
    public void searchProductByName() {
        System.out.print("Nhap ten: ");
        String ten = scanner.nextLine().toLowerCase();
        boolean found = false;
        for(Product product : products) {
            if(product.getName().toLowerCase().contains(ten)) {
                System.out.println(product);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Khong tim thay san pham");
        }
    }

    //Tang dan theo gia
    public void sortByPriceAsc() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Da sap xep tang dan theo gia");
    }

    //Giam dan theo gia
    public void sortByPriceDesc() {
        products.sort((p1,p2)->Double.compare(p2.getPrice(),p1.getPrice()));
        System.out.println("Da sap xep giam dan theo gia");
    }
}
