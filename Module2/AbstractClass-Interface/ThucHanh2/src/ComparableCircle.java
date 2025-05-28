import java.lang.Comparable;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        // Sử dụng Double.compare() để tránh lỗi số thực
        return Double.compare(this.getRadius(), o.getRadius());
    }
}
