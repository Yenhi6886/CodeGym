package BaiDuocGiao2;

public class Emloyee {
    private int id;
    private String name;
    private String position;
    private double salary;
    private String hireDate;
    private String department;

    public Emloyee() {

    }

    public Emloyee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Emloyee(int id, String name, String position, double salary, String hireDate, String department) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //Tính tiền thưởng dựa trên phần trăm (percentage) được truyền vào
    public double caculateBonus(double percentage) {
        return salary * (percentage / 100);
    }

    //Tăng lương của nhân viên dựa trên phần trăm (percentage) được truyền vào.
    public void raiseSalary(double percentage) {
        this.salary += (salary * (percentage / 100));
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Department: " + department);
    }

    public boolean isManager() {
        return position.toLowerCase().contains("manager");
        //contains():  phương thức trong lớp String,kiểm xem 1 chuỗi có chứa 1 chuỗi con cụ thể không.
    }
}
