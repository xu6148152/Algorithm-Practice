package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 19/10/2017.
 */

public class ReverseString {

    /**
     * Write a function that takes a string as input and returns the string reversed.
     * <p>
     * Example:
     * Given s = "hello", return "olleh".
     *
     * @param s
     * @return
     */
    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0, j = charArray.length - 1; i <= j; i++, j--) {
            char tmpChar = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmpChar;

        }
        return String.valueOf(charArray);
    }
}
