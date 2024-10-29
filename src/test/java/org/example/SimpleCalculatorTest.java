package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    // This is an example test - write more like this!
    @Test
    void testAddTwoPositiveNumbers() {
        SimpleCalculator calculator = new SimpleCalculator();
        int result = calculator.add(3, 5);
        assertEquals(8, result);
    }
}
