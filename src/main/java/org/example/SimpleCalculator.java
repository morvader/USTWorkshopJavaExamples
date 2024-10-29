package org.example;

public class SimpleCalculator {

    /**
     * Adds two numbers
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Multiplies two numbers
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides two numbers
     * Throws IllegalArgumentException if b is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return (double) a / b;
    }

    /**
     * Returns true if number is positive (greater than zero)
     */
    public boolean isPositive(int number) {
        return number > 0;
    }
}