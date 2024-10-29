package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

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
    void testCountVowelsEmptyString() {
        assertEquals(0, analyzer.countVowels(""));
    }

    @Test
    void testCountVowelsNullString() {
        assertEquals(0, analyzer.countVowels(null));
    }

    @Test
    void testCountVowelsUpperCaseString() {
        assertEquals(3, analyzer.countVowels("HELLO WorlD"));
    }

    @Test
    void testCountVowelsWithNumberstring() {
        assertEquals(3, analyzer.countVowels("HE4LL6O W6orl3D8"));
    }

    @Test
    void testCountVowelsSpecialCharactersstring() {
        assertEquals(2, analyzer.countVowels("H@e()o"));
    }

    @Test
    void testIsPalindromeSimple() {
        assertTrue(analyzer.isPalindrome("madam"));
    }
    @Test
    void testIsPalindromeSentence() {
        assertTrue(analyzer.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void testIsPalindromeWithNumbers() {
        assertTrue(analyzer.isPalindrome("m313m"));
    }

    @Test
    void testIsPalindromeEmptyString() {
        assertFalse(analyzer.isPalindrome(""));
    }

    @Test
    void testIsPalindromeNullString() {
        assertFalse(analyzer.isPalindrome(null));
    }

    @Test
    void testIsNotPalindrome() {
        assertFalse(analyzer.isPalindrome("Not Palindrome"));
    }

    @Test
    void testGetMostFrequentCharThrowsExceptionForNull() {
        assertThrows(IllegalArgumentException.class,
                () -> analyzer.getMostFrequentChar(null));
    }

    @Test
    void testMostFrequentCharEmptyString(){
        assertThrows(IllegalArgumentException.class,
                () -> analyzer.getMostFrequentChar(""));

    }

    @ParameterizedTest
    @CsvSource({
            "abcdefga, a",
            "aaabbccdd, a",
            "aaBBBccdd, B",
            "abcabcabca, a",
            "aaaBBBBBB, B"
    })
    void testMostFrequentChar(String input, Character mostFrequent) {
        assertEquals(mostFrequent, analyzer.getMostFrequentChar(input));
    }

    @Test
    void compareArrays(){
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();

        int[] a1= {1,2,3};
        int[] b1 = {1,2,3};

        a.add(1);
        a.add(2);
        a.add(3);

        b.add(1);
        b.add(2);
        b.add(3);

        assertEquals(a,b);

        //assertEquals(a1,b1);

        assertArrayEquals(a1,b1);

    }
}
