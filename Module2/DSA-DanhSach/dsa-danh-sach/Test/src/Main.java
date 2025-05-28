import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /* List<Student> students = new ArrayList<>();
//        Student std1 = new Student();
//        students.add(std1);
        students.add(new Student("Nhi",21,3.6));
        students.add(new Student("An",22,3.5));
        students.add(new Student("Thien",22,3.5));
        students.add(new Student("Chien",26,3.6));
        students.add(new Student("Hoang",30,3.3));
        students.add(new Student("Anh",21,3.6));
        students.add(new Student("Toan",22,3.5));

        for (Student student : students) {
            System.out.println(student);
        }*/

        List<Student> students = new LinkedList<>();
        students.add(new Student("Nhi",21,3.6));

        //duyet students
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
