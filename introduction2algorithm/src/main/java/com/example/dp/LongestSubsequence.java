package com.example.dp;

import java.util.TreeSet;

/**
 * Created by binea on 2016/10/20.
 */

public class LongestSubsequence {
    public int[][] getLongestSubsequence(int[] x, int y[]) {

        int m = x.length;
        int n = y.length;

        int[][] b = new int[m][n];
        int[][] c = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (x[i] == y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 0;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = -1;
                }
            }
        }

        return b;
    }

    public void display(int[][] b, int[] x, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (b[i][j] == 1) {
            display(b, x, i - 1, j - 1);
            System.out.print(x[i] + " ");
        } else if (b[i][j] == 0) {
            display(b, x, i - 1, j);
        } else {
            display(b, x, i, j - 1);
        }
    }

    public TreeSet<Integer> longestAscendSubsequence(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            Integer ceiling = set.ceiling(i);
            if (ceiling != null) set.remove(ceiling);
            set.add(i);
        }
        return set;
    }
}
