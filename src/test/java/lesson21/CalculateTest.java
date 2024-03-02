package lesson21;

import extend.Calculate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateTest {

    private final int EXP_INT = 5;
    private final String EXP_TEST = "1+3*2-4/2";
    private final String[] EXPECTED = {"1", "+", "3", "*", "2", "-", "4", "/", "2"};
    @Test
    public void testExpressionToTokens() {

        String[] actual = Calculate.expressionToTokens(EXP_TEST);
        Assertions.assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void testCalculate() {
        int actual = Calculate.calculate(EXPECTED);
        Assertions.assertEquals(EXP_INT, actual);
    }
}
