package ThucHanh1;

public class MainSquare {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(4.5);
        System.out.println(square);

        square = new Square(4,"black",true);
        System.out.println(square);
    }
}
