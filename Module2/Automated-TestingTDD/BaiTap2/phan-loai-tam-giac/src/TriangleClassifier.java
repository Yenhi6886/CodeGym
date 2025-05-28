public class TriangleClassifier {
    public static String classifyTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return "Not a triangle";
        }
        if (a == b && b == c) {
            return "Equilateral triangle";
        }
        if (a == b || a == c || b == c) {
            return "Isosceles triangle";
        }
        if ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a)) {
            return "Right triangle";
        }
        return "Scalene triangle";
    }
}
