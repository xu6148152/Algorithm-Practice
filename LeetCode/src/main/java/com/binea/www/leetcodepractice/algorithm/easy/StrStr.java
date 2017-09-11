package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 11/9/2017.
 */

public class StrStr {

    /**
     * Implement strStr().
     * <p>
     * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     * @param hayStack
     * @param needle
     * @return
     */
    public int strStr(String hayStack, String needle) {
        if (hayStack == null || needle == null) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        if (hayStack.length() < needle.length()) {
            return -1;
        }

        char firstChar = needle.charAt(0);

        int needleLength = needle.length();

        for (int i = 0; i < hayStack.length(); i++) {
            if (firstChar == hayStack.charAt(i)) {
                int j = i;
                int k = 0;
                while (k < needleLength && j < hayStack.length() && hayStack.charAt(j) == needle.charAt(k)) {
                    j++;
                    k++;
                }
                if (k == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStrIndexOf(String hayStack, String needle) {
        if (hayStack == null) {
            return -1;
        }
        return hayStack.indexOf(needle);
    }
}
