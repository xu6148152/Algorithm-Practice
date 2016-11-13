package com.example.dp;

/**
 * Created by binea on 2016/11/13.
 */

public class DpPractice {
    public int countWays(int n) {
        int[] steps = new int[n + 1];
        if (n >= 0) {
            steps[0] = 1;
        }
        if (n >= 1) {
            steps[1] = 1;
        }
        if (n >= 2) {
            steps[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2] + steps[i - 3];
        }
        return steps[n];
    }

}
