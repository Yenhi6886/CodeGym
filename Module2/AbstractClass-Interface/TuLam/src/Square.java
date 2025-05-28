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
        return getWidth(); //getHeight cũng được
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }

    @Override
    public void resize(double percent) {
        double newside = getSide() + getSide() * percent / 100;
        setSide(newside);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setHeight(double height) {
        setSide(height);
    }

    @Override
    public String toString() {
        return "Square - Side: " + getSide() + ", Area: " + getArea();
    }

}
