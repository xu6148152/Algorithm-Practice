package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 12/9/2017.
 */

public class LengthOfLastWord {

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     * <p>
     * If the last word does not exist, return 0.
     * <p>
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * <p>
     * For example,
     * Given s = "Hello World",
     * return 5.
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] results = s.split(" ");
        if (results.length > 0) {
            return results[results.length - 1].length();
        }
        return 0;
    }
}
