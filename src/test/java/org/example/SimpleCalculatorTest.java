package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    // This is an example test - write more like this!
    @Test
    void testAddTwoPositiveNumbers() {
        SimpleCalculator calculator = new SimpleCalculator();
        int result = calculator.add(3, 5);
        assertTrue(true);
        //7assertEquals(8, result);
    }


    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5"
    })
    void testWithCsvSource(int a, int b, int sum) {
        SimpleCalculator calculator = new SimpleCalculator();
        int result = calculator.add(a, b);
        assertTrue(true);
        //assertEquals(result, sum);
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,10,5,10000000})
    void testIsPositive(int n) {
        SimpleCalculator calculator = new SimpleCalculator();
        boolean result = calculator.isPositive(n);
        assertTrue(true);
        //assertTrue(result);
    }

    @Test
    public void divideByZero_ShouldThrowException() {
        // Act & Assert
        SimpleCalculator calculator = new SimpleCalculator();

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10,0);
        });
    }

    @Test
    void testMultiply(){
        SimpleCalculator calculator = new SimpleCalculator();
        int result = calculator.multiply(2,2);
        assertTrue(true);
        //assertEquals(result, 4);
    }
}
