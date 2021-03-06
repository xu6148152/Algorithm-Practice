package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 10/01/2017.
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易 

public class LongestPalindromicSubstring {
    private int lo, maxLen;

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     * Example:
     *
     * Input: "babad"
     *
     * Output: "bab"
     *
     * Note: "aba" is also a valid answer.
     * Example:
     *
     * Input: "cbbd"
     *
     * Output: "bb"
     */
    public String longestPalindrome15ms(String s) {
        int len = s.length();
        if (len > 1000) {
            return null;
        }
        if (len < 2) {
            return s;
        }

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public String longestPalindrome14ms(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        if (len <= 2) {
            return s;
        }

        char[] chars = s.toCharArray();
        int rs = 0, re = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (isPalindrome(chars, i - max - 1, i)) {
                rs = i - max - 1;
                re = i;
                max += 2;
            } else if (isPalindrome(chars, i - max, i)) {
                rs = i - max;
                re = i;
                max += 1;
            }
        }
        return s.substring(rs, re + 1);
    }

    private boolean isPalindrome(char[] chars, int start, int end) {
        if (start < 0 || start > end) {
            return false;
        }

        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }
}
