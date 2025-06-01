import java.io.*;
import java.util.List;

public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private String manufacturer; //Hàng sản xuất
    private String description;  //Mô tả
    private static final long serialVersionUID = 1L;

    public Product() {
    }

    public Product(String id, String name, double price, String manufacturer, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Mã SP: " + id +
                ", Tên SP: " + name +
                ", Giá: " + price +
                ", Hãng: " + manufacturer +
                ", Mô tả: " + description;
    }


    //Hàm ghi danh sách sản phẩm ra file (ghi đè)
    public static void writeProductListToFile(String path, List<Product> product) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(product); //Ghi cả list vào file
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    //Hàm đọc danh sách sản phẩm từ file
    public static List<Product> readProductListFromFile(String path) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Product>) ois.readObject();
        } catch (Exception e) {
//            System.out.println("Lỗi đọc file: " + e.getMessage());
            return null;
        }
    }
}
