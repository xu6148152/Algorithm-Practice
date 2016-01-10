package com.binea.www.leetcodepractice.algorithm;

import java.util.HashMap;

/**
 * Created by xubinggui on 1/10/16.
 */
public class LongestSubString {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
     * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
     */

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;
        for(int i = 0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
