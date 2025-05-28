package BaiTapDuocGiao;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Hoa");
        student1.displayInfo();

        Student student2 = new Student("Thư", "C01");
        student2.updateGPA(3.7);
        student2.displayInfo();

        Student student3 = new Student(1, "Ngọc", "02/02/2002", "Nu", "C02", 3.4, "Logictics");
        student3.displayInfo();
        student3.transferClass("C2024");
        student3.updateGPA(3.9);
        student3.displayInfo();
    }
}
