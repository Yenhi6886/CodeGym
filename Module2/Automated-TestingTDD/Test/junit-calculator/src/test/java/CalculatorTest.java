import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        int expected = 5;
        int actual = new Calculator().add(2, 3);
    }

}