package com.binea.www.leetcodepractice.algorithm;

import java.util.Arrays;

//  Created by xubinggui on 9/6/16.
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
public class NumDecodings {
    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given an encoded message containing digits, determine the total number of ways to decode it.
     *
     * For example,
     * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
     *
     * The number of ways decoding "12" is 2.
     */
    public int numDecodings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int one = 0, two = 0;
        int[] book = new int[s.length() + 1];
        Arrays.fill(book, 0);
        book[0] = 1;
        book[1] = (s.charAt(0) >= '1' && s.charAt(0) <= '9') ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            one = (s.charAt(i) - '0');
            two = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (one >= 1 && one <= 9) {
                book[i + 1] += book[i];
            }
            if (two >= 10 && two <= 26) {
                book[i + 1] += book[i - 1];
            }
        }
        return book[book.length - 1];
    }
}
