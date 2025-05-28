public class Square extends Rectangle{
    public Square(){

    }
    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color,boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth(); //getHeight cũng được
    }
    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
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
        return "A Square width side= "+getSide()+" ,which is a subclass of "+super.toString();
    }
}
