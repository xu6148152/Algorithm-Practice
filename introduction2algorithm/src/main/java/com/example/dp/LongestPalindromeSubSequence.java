package com.example.dp;

/**
 * Created by binea on 2016/10/23.
 */

public class LongestPalindromeSubSequence {
    /**
     * 对于任意字符串，如果头尾字符相同，那么字符串的最长子序列等于去掉首尾的字符串的最长子序列加上首尾；如果首尾字符不同，则最长子序列等于去掉头的字符串的最长子序列和去掉尾的字符串的最长子序列的较大者。
     *
     * 因此动态规划的状态转移方程为：
     *
     * 设字符串为str，长度为n，p[i][j]表示第i到第j个字符间的子序列的个数（i<=j），则：
     *
     * 状态初始条件：dp[i][i]=1 （i=0：n-1）
     *
     * 状态转移方程：dp[i][j]=dp[i+1][j-1] + 2  if（str[i]==str[j]）
     *
     * dp[i][j]=max(dp[i+1][j],dp[i][j-1])  if （str[i]!=str[j]）
     */

    public int longestPalindromSubSequence(String input) {
        int n = input.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][input.length() - 1];
    }

    // Transform S into T.  
// For example, S = "abba", T = "^#a#b#b#a#$".  
// ^ and $ signs are sentinels appended to each end to avoid bounds checking  
    String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";
        String ret = "^";
        for (int i = 0; i < n; i++)
            ret += "#" + s.substring(i, 1);
        ret += "#$";
        return ret;
    }

    public String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[][] a = new int[n][n];
        int mid = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int j = 2 * mid - i; // 找到i关于mid对称的位置
            int tmp = a[j][0];
            a[i][0] = (R > i) ? Math.min(R - i, tmp) : 0;
            // Attempt to expand palindrome centered at i  
            while (T.charAt(i + 1 + a[i][0]) == T.charAt(i - 1 - a[i][0]))
                a[i][0]++;
            // If palindrome centered at i expand past R,  
            // adjust center based on expanded palindrome.  
            if (i + a[i][0] > R) {
                mid = i;
                R = i + a[i][0];
            }
        }
        // Find the maximum element in a.  
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i][0] > maxLen) {
                maxLen = a[i][0];
                centerIndex = i;
            }
        }
        return s.substring((centerIndex - 1 - maxLen) / 2, maxLen);
    }
}
