public class Square extends Rectangle implements Resizeable {

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
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public void resize(double percent) {
        double newSide = getSide() + getSide() * percent / 100;
        setSide(newSide);
    }

    @Override
    public String toString() {
        return "Square - side: " + getSide() + ", area: " + getArea();
    }
}
