import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student0 = new Student("Linh",20,"HN");
        Student student1 = new Student("Vân",22,"BG");
        Student student2 = new Student("Minh",31,"HY");
        Student student3 = new Student("Trong",22,"BN");

        List<Student> list = new ArrayList<Student>();
        list.add(student0);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        Collections.sort(list);
        for (Student st: list) {
            System.out.println(st.toString());
        }

        Age age = new Age();
        Collections.sort(list, age);
        System.out.println("So sánh theo tuổi: ");
        for (Student st: list) {
            System.out.println(st.toString());
        }

    }
}
