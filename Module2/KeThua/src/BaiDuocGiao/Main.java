package BaiDuocGiao;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.displayInfo();
        System.out.println("Hạng vip: "+customer.isVIP());
        System.out.println("");

        Customer customer1 = new Customer("Nguyễn Văn Thanh");
        customer1.displayInfo();
        customer1.makePurchases(5000000.0);
        System.out.println("Hạng vip: "+(customer1.isVIP() ? "VIP" : "No VIP"));
        System.out.println("");

        Customer customer2 = new Customer("Trần Hải Thúy","thuy@gmail.com","0966688866");
        customer2.displayInfo();
        customer2.makePurchases(1000.0);
        System.out.println("Hạng vip: "+(customer2.isVIP() ? "VIP" : "No VIP"));
    }
}
