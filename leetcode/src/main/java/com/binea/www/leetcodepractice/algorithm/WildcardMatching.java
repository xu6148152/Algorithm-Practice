package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 03/01/2017.
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

public class WildcardMatching {

    /**
     * Implement wildcard pattern matching with support for '?' and '*'.
     *
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     *
     * The matching should cover the entire input string (not partial).
     *
     * The function prototype should be:
     * bool isMatch(const char *s, const char *p)
     *
     * Some examples:
     * isMatch("aa","a") → false
     * isMatch("aa","aa") → true
     * isMatch("aaa","aa") → false
     * isMatch("aa", "*") → true
     * isMatch("aa", "a*") → true
     * isMatch("ab", "?*") → true
     * isMatch("aab", "c*a*b") → false
     */
    public boolean isMatch93ms(String str, String pattern) {
        int s = 0, p = 0, match = 0, startIdx = -1;
        while (s < str.length()) {
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                startIdx = p;
                match = s;
                p++;
            } else if (startIdx != -1) {
                p = startIdx + 1;
                match++;
                s = match;
            } else {
                return false;
            }
        }

        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }
        return p == pattern.length();
    }

    public boolean isMatchDP(String str, String pattern) {
        boolean[][] match = new boolean[str.length() + 1][pattern.length() + 1];
        match[str.length()][pattern.length()] = true;
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) != '*') {
                break;
            }
            match[str.length()][i] = true;
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                if (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
                    match[i][j] = match[i + 1][j + 1];
                } else if (pattern.charAt(j) == '*') {
                    match[i][j] = match[i + 1][j] || match[i][j + 1];
                } else {
                    match[i][j] = false;
                }
            }
        }
        return match[0][0];
    }
}
