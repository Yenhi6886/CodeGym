import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void getNextDay() {
        String result = NextDayCalculator.getNextDay(1, 1, 2018);
        assertEquals("2/1/2018",result);
    }
}