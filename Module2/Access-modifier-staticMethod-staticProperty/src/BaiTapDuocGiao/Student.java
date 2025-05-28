package BaiTapDuocGiao;

public class Student {
    private int id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String classId;
    private double gpa;
    private String major;

    //Mac dinh
    public Student() {
        this.dateOfBirth = "01/01/2001";
        this.gender = "Male";
        this.classId = "C03";
    }

    //Voi ten
    public Student(String name) {
        this.name = name;
    }

    //Ten va lop
    public Student(String name, String classId) {
        this.name = name;
        this.classId = classId;
    }

    //Full
    public Student(int id, String name, String dateOfBirth, String gender, String classId, double gpa, String major) {
        this.name = name;
        this.classId = classId;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.gpa = gpa;
        this.major = major;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    //Diem trung binh moi
    public void updateGPA(double newScore) {
        this.gpa = newScore;
    }

    //Chuyen hoc sinh sang lop moi
    public void transferClass(String newCLass) {
        this.classId = newCLass;
    }

    //Sinh vien danh du
    public boolean isHonorStudent() {
        return gpa >= 3.5;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Date: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Class: " + classId);
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Honor student: " + (isHonorStudent() ? "Yes" : "No"));
    }
}
