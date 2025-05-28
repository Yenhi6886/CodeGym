package BaiDuocGiao2;

public class Main {
    public static void main(String[] args) {
        Emloyee em = new Emloyee();
        em.displayInfo();
        System.out.println("------------");

        Emloyee em2 = new Emloyee("Ngọc Hà","Senior");
        em2.displayInfo();
        System.out.println("------------");

        Emloyee em3 = new Emloyee(3,"Hồng Linh","Manager", 9000000.0, "20/26/2023","Kĩ thuật");
        em3.displayInfo();
        System.out.println((em3.isManager()?"Là manager":"Không phải manager"));
    }
}
