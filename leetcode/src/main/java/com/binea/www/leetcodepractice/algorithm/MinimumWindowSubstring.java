package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 13/01/2017.
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

public class MinimumWindowSubstring {

    /**
     * Given a string s and a string T, find the minimum window in s which will contain all the characters in T in complexity O(n).
     *
     * For example,
     * s = "ADOBECODEBANC"
     * T = "ABC"
     * Minimum window is "BANC".
     *
     * Note:
     * If there is no such window in s that covers all characters in T, return the empty string "".
     *
     * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in s.
     */
    public String minWindow(String s, String t) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        int[] map = new int[256];
        int end = 0;
        int start = 0;
        int min_length = Integer.MAX_VALUE;
        for (int i = 0; i < t_array.length; i++)
            map[t_array[i]]++;
        int count = t_array.length;
        int min_start = 0;
        while (end < s_array.length) {
            if (map[s_array[end]] > 0) {
                count--;
            }
            map[s_array[end]]--;
            while (count == 0) {
                if ((end - start + 1) < min_length) {
                    min_length = end - start + 1;
                    min_start = start;
                }
                map[s_array[start]]++;
                if (map[s_array[start]] > 0) {
                    count++;
                }
                start++;
            }
            end++;
        }
        if (min_start + min_length > s_array.length) {
            return "";
        }
        return s.substring(min_start, min_start + min_length);
    }
}
