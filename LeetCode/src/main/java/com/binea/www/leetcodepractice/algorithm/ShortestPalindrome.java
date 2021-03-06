package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 10/9/16.
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

public class ShortestPalindrome {

    /**
     * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome
     * you can find by performing this transformation.
     *
     * For example:
     *
     * Given "aacecaaa", return "aaacecaaa".
     *
     * Given "abcd", return "dcbabcd".
     */
    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] c_str = s.toCharArray();
        // the next array stores the failure function of each position.
        int[] next = new int[c_str.length];
        next[0] = -1;
        int i = -1, j = 0;
        while (j < c_str.length - 1) {
            if (i == -1 || c_str[i] == c_str[j]) {
                i++;
                j++;
                next[j] = i;
                if (c_str[j] == c_str[i]) {
                    next[j] = next[i];
                }
            } else {
                i = next[i];
            }
        }
        // match the string with its reverse.
        i = c_str.length - 1;
        j = 0;
        while (i >= 0 && j < c_str.length) {
            if (j == -1 || c_str[i] == c_str[j]) {
                i--;
                j++;
            } else {
                j = next[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (i = c_str.length - 1; i >= j; i--)
            sb.append(c_str[i]);
        for (char c : c_str)
            sb.append(c);
        return sb.toString();
    }
}
