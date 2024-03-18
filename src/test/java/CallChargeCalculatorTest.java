import org.example.CallChargeCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CallChargeCalculatorTest {

    private final CallChargeCalculator calculator = new CallChargeCalculator();

    @Test
    void testLessThan20Minutes() {
        assertEquals(0.05, calculator.calculateCharge(30), "Charging for less than 1 minute");
        assertEquals(1.00, calculator.calculateCharge(1200), "Charging for 20 minutes");
    }

    @Test
    void testMoreThan20Minutes() {
        assertEquals(1.10, calculator.calculateCharge(1260), "Charging for 21 minutes");
    }

    @Test
    void testEdgeCase20Minutes() {
        assertEquals(1.00, calculator.calculateCharge(1200), "Charging for exactly 20 minutes");
    }

    @Test
    void testInvalidDuration() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculateCharge(-1));
        assertTrue(exception.getMessage().contains("Invalid duration"));

        exception = assertThrows(IllegalArgumentException.class, () -> calculator.calculateCharge(108001));
        assertTrue(exception.getMessage().contains("Duration exceeds limit"));
    }
}
