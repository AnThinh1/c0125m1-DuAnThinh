import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class NextDayCalculatorTest {
    @Test
    public void testNextDay_NormalCase() {
        String result = NextDayCalculator.findNextDay(10, 5, 2024);
        assertEquals("11/5/2024", result);
    }
    @Test
    public void testNextDay_NormalCase1() {
        String result = NextDayCalculator.findNextDay(11, 5, 2024);
        assertEquals("12/5/2024", result);
    }
}
