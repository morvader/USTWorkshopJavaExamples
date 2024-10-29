package org.example;

public class StringAnalyzer {

    /**
     * Counts how many vowels (a,e,i,o,u) are in the input string
     * Returns 0 if input is null or empty
     */
    public int countVowels(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return (int) input.toLowerCase()
                .chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> "aeiou".contains(String.valueOf(ch)))
                .count();
    }

    /**
     * Returns true if the input is a palindrome (reads the same forwards and backwards)
     * Ignores case, spaces, and punctuation
     * Returns false if input is null or empty
     */
    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        String cleanStr = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversed);
    }

    /**
     * Returns the most frequent character in the string
     * In case of tie, returns the character that appears first
     * Throws IllegalArgumentException if input is null or empty
     */
    public char getMostFrequentChar(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        return input.chars()
                .mapToObj(ch -> (char) ch)
                .reduce((ch1, ch2) ->
                        input.chars().filter(c -> c == ch1).count() >=
                                input.chars().filter(c -> c == ch2).count() ? ch1 : ch2)
                .get();
    }

    /**
     * Checks if two strings are anagrams of each other
     * Ignores case and spaces
     * Returns false if either string is null
     */
    public boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        str1 = str1.toLowerCase().replaceAll("\\s", "");
        str2 = str2.toLowerCase().replaceAll("\\s", "");

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        java.util.Arrays.sort(chars1);
        java.util.Arrays.sort(chars2);

        return java.util.Arrays.equals(chars1, chars2);
    }
}
