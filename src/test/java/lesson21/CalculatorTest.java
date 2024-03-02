package lesson21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(4, calculator.add(2, 2));
    }

    @Test
    public void testSub() {
        Assertions.assertEquals(10, calculator.sub(30, 20));
    }

    @Test
    public void testMul() {
        Assertions.assertEquals(9, calculator.mul(3, 3));
    }

    @Test
    public void testDiv() {
        Assertions.assertEquals(3, calculator.div(12, 4));
    }
}
