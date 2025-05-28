package ThucHanh1;

public class Main {
    public static void main(String[] args) {
        StaticMethods.change();
        StaticMethods s1 = new StaticMethods(1, "A");
        StaticMethods s2 = new StaticMethods(2, "B");
        StaticMethods s3 = new StaticMethods(3, "C");
        StaticMethods s4 = new StaticMethods(4, "D");

        s1.display();
        s2.display();
        s3.display();
        s4.display();

    }
}
