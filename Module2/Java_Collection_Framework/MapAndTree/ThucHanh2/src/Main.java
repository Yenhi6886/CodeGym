import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student std1 = new Student("Ngoc",40,"VP");
        Student std2 = new Student("Nhi", 21, "CG");
        Student std3 = new Student("Vi", 11, "CG");
        Student std4 = new Student("Ha", 14, "HM");
        Student std5 = new Student("Ha", 14, "HM");

        //Map
        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        studentMap.put(1, std1);
        studentMap.put(2, std2);
        studentMap.put(8, std3);
        studentMap.put(4, std4);
        studentMap.put(4, std1);
        studentMap.put(5, std3);
        studentMap.put(6, std5);
        for (Map.Entry<Integer, Student> student : studentMap.entrySet()) {
            System.out.println(student.toString());
        }
        System.out.println("------------");

        //Set
        Set<Student> students = new HashSet<Student>();
        students.add(std1);
        students.add(std2);
        students.add(std3);
        students.add(std4);
        students.add(std1);
        students.add(std3);
        students.add(std5);
        for(Student student : students) {
            System.out.println(student.toString());
        }
    }
}
