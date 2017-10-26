package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 25/10/2017.
 */

public class ReverseVowelsOfAString {

    /**
     * Write a function that takes a string as input and reverse only the vowels of a string.
     * <p>
     * Example 1:
     * Given s = "hello", return "holle".
     * <p>
     * Example 2:
     * Given s = "leetcode", return "leotcede".
     * <p>
     * Note:
     * The vowels does not include the letter "y".
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !vowels.contains(chars[start] + "")) {
                start++;
            }

            while (start < end && !vowels.contains(chars[end] + "")) {
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }

        return new String(chars);
    }
}
