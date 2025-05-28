package ThucHanh1;

public class StaticMethods {
    private int rollno;
    private String name;
    private static String college = "BB";

    StaticMethods(int r, String n) {
        rollno = r;
        name = n;
    }

    static void change() {
        college = "CODEGYM";
    }

    void display() {
        System.out.println(rollno + " "+ name + " " + college);
    }
}
