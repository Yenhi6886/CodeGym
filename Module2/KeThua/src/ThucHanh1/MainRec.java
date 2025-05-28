package ThucHanh1;

public class MainRec {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        System.out.println(r);

        r = new Rectangle(4.3, 5.5);
        System.out.println(r);

        r = new Rectangle( 5.3, 4.2, "red", true);
        System.out.println(r);
    }
}
