import java.io.*;
import java.util.List;

public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private String manufactured;
    private String describe;
    private static final long serialVersionUID = 1L;

    public Product() {
    }

    public Product(String id, String name, double price, String manufactured, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufactured = manufactured;
        this.describe = describe;
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

    public String getManufactured() {
        return manufactured;
    }

    public void setManufactured(String manufactured) {
        this.manufactured = manufactured;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product- id: "+id+ ", SP: "+name+", Price: "+price+", Manufactured: "+manufactured+", Describe: "+describe;
    }

    //Ghi san pham từ list
    public static void writeProductListFile(String path, List<Product> products) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(products);
            System.out.println("Ghi file thành công");
        } catch (Exception e) {
            System.err.println("Lỗi ghi file!"+e.getMessage());
        }
    }

    //Đọc sản phầm từ list
    public static List<Product> readProductListFile(String path) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Product>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
