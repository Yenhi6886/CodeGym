public class Square extends Rectangle implements Colorable {

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void howToColor() {
        System.out.println("Color");
    }

    @Override
    public String toString() {
        return "Square - side: " + getSide() + ", area: " + getArea();
    }
}
