package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitBasicTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("At the beginning of test execution");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each test");
    }

    @AfterEach
    public void teardown() {
        System.out.println("After each test");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("At the end of all tests");
    }

    @Test
    public void addTwoNumbers_ShouldReturnSum() {
        // Arrange
        int a = 3;
        int b = 5;
        int expectedResult = 8;

        // Act & Assert
        assertEquals(expectedResult, a + b, "The sum is not correct");
    }

    @Test
    public void stringStartsWith_ShouldReturnTrue() {
        // Arrange
        String inputString = "I am automating tests";
        String startText = "I am";

        // Act & Assert
        assertTrue(inputString.startsWith(startText));
    }

    @Test
    public void divideByZero_ShouldThrowException_TryCatchApproach() {
        try {
            // Act
            int result = 10 / 0;
            fail("Exception was not thrown");
        } catch (ArithmeticException exception) {
            // Assert
            System.out.println("Exception caught successfully");
            assertTrue(true);
        }
    }

    @Test
    public void divideByZero_ShouldThrowException_ModernApproach() {
        // Act & Assert
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        });
    }
}