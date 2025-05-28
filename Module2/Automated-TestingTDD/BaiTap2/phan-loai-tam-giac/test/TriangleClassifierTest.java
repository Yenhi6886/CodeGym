import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleClassifierTest {

    @org.junit.jupiter.api.Test
    void classifyTriangle() {
        String result = TriangleClassifier.classifyTriangle(4,6,9);
        assertEquals("Scalene triangle", result);
    }

}