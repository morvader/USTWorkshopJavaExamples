package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAnalyzerTest {
    private StringAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new StringAnalyzer();
    }

    @Test
    void testCountVowelsBasicWord() {
        assertEquals(2, analyzer.countVowels("hello"));
    }

    @Test
    void testIsPalindromeSimple() {
        assertTrue(analyzer.isPalindrome("madam"));
    }

    @Test
    void testGetMostFrequentCharThrowsExceptionForNull() {
        assertThrows(IllegalArgumentException.class,
                () -> analyzer.getMostFrequentChar(null));
    }

    @Test
    void testAreAnagramsSimple() {
        assertTrue(analyzer.areAnagrams("silent", "listen"));
    }
}
