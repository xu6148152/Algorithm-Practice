package com.binea.www.leetcodepractice.algorithm;
//  Created by xubinggui on 11/01/2017.
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

// Created by binea on 3/13/17.

import java.util.Arrays;

public class EditDistance {

    /**
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
     * <p>
     * You have the following 3 operations permitted on a word:
     * <p>
     * a) Insert a character
     * b) Delete a character
     * c) Replace a character
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance_12ms(String word1, String word2) {
        int[] prev = new int[word2.length() + 1];
        int[] curr = new int[word2.length() + 1];
        for (int i = 1; i <= word2.length(); i++) {
            prev[i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            curr[0] = i;
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j - 1], Math.min(curr[j - 1], prev[j]));
                }
            }
            prev = Arrays.copyOf(curr, curr.length);
        }
        return prev[word2.length()];
    }

    public int minDistance_10ms(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int l1 = word1.length();
        int l2 = word2.length();
        int[] minDist = new int[l2 + 1];
        for (int j = 0; j <= l2; j++) {
            minDist[j] = j;
        }

        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int prev;//store minDist[i - 1][j -1]
        for (int i = 1; i <= l1; i++) {
            minDist[0] = i - 1;
            prev = minDist[0];
            for (int j = 1; j <= l2; j++) {
                int temp = minDist[j];
                if (chs1[i - 1] == chs2[j - 1]) {
                    minDist[j] = prev;
                } else {
                    minDist[j] = Math.min(minDist[j], Math.min(prev, minDist[j - 1])) + 1;
                }
                prev = temp;
            }
        }
        return minDist[l2];
    }

    public int minDistance_8ms(String word1, String word2) {
        if (word1 == null || word1.length() == 0)
            return word2.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        return minDist(w1, w2, dp, word1.length(), word2.length());
    }

    public int minDist(char[] w1, char[] w2, int[][] dp, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (dp[m][n] != 0)
            return dp[m][n];
        if (w1[m - 1] == w2[n - 1])
            return dp[m][n] = minDist(w1, w2, dp, m - 1, n - 1);
        return dp[m][n] = 1 + Math.min(minDist(w1, w2, dp, m, n - 1), Math.min(minDist(w1, w2, dp, m - 1, n), minDist(w1, w2, dp, m - 1, n - 1)));
    }
}
