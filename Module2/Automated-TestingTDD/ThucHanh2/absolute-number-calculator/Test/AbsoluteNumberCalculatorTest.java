import static org.junit.jupiter.api.Assertions.assertEquals;

class AbsoluteNumberCalculatorTest {

    @org.junit.jupiter.api.Test
    void testFindAbsolute0() {
        int number = 0;
        int expected = 0;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result); //assertEquals(): so sánh giá trị mong muốn và giá trị thực tế
    }

    @org.junit.jupiter.api.Test
    void testFindAbsolute1() {
        int number = 1;
        int expected = 1;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }
 @org.junit.jupiter.api.Test
    void testFindAbsolute2() {
        int number = 2;
        int expected = 2;

        int result = AbsoluteNumberCalculator.findAbsolute(number);
        assertEquals(expected, result);
    }

}
