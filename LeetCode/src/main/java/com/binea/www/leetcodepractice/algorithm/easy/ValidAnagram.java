package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 8/10/2017.
 */

public class ValidAnagram {

    /**
     * Given two strings s and t, write a function to determine if t is an anagram of s.
     * <p>
     * For example,
     * s = "anagram", t = "nagaram", return true.
     * s = "rat", t = "car", return false.
     * <p>
     * Note:
     * You may assume the string contains only lowercase alphabets.
     * <p>
     * Follow up:
     * What if the inputs contain unicode characters? How would you adapt your solution to such case?
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;

        if (s == null) return false;

        if (t == null) return false;

        if (s.length() != t.length()) return false;

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
