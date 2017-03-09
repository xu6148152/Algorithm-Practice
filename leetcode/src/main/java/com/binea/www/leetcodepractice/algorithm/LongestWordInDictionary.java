package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by binea on 3/9/17.
 */

public class LongestWordInDictionary {

    /**
     * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
     * <p>
     * Example 1:
     * Input:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     * <p>
     * Output:
     * "apple"
     * Example 2:
     * Input:
     * s = "abpcplea", d = ["a","b","c"]
     * <p>
     * Output:
     * "a"
     * Note:
     * All the strings in the input will only contain lower-case letters.
     * The size of the dictionary won't exceed 1,000.
     * The length of all the strings in the input won't exceed 1,000.
     *
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            }

            if (i == dictWord.length() && dictWord.length() >= longest.length()) {
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) {
                    longest = dictWord;
                }
            }
        }
        return longest;
    }

    public String findLongestWord_35ms(String s, List<String> d) {
        if (s == null || d == null) return "";
        Collections.sort(d, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length())
                    return b.length() - a.length();
                else return a.compareTo(b);
            }
        });
        char[] searchingWord = s.toCharArray();
        char[] wordinDictionary;
        int i, j;
        for (String word : d) {
            wordinDictionary = word.toCharArray();
            j = 0;
            i = 0;
            while (j < searchingWord.length && i < wordinDictionary.length) {
                while (j < searchingWord.length && wordinDictionary[i] != searchingWord[j]) j++;
                if (j < searchingWord.length && searchingWord[j] == wordinDictionary[i]) i++;
                j++;
            }
            if (i >= wordinDictionary.length) return new String(wordinDictionary);
        }
        return "";
    }

    public String findLongestWord_17ms(String s, List<String> d) {
        String longest = "";
        for (String word : d)
            if (isBetter(word, longest) && isSubsequence(word, s))
                longest = word;
        return longest;
    }

    private boolean isBetter(String a, String b) {
        return a.length() > b.length() ||
                a.length() == b.length() && a.compareTo(b) < 0;
    }

    private boolean isSubsequence(String a, String b) {
        int start = -1;
        for (int i = 0; i < a.length(); i++) {
            start = b.indexOf(a.charAt(i), start + 1);
            if (start < 0)
                return false;
        }
        return true;
    }
}
