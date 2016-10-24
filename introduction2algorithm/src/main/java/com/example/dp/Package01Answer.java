package com.example.dp;

/**
 * Created by binea on 2016/10/24.
 */

public class Package01Answer {
    class Package {
        int weight;
        int value;
    }

    public int[] getPackageAnswer(int[] value, int[] weight, int totalWeight) {

        int newValue = 0;
        int[][] state = new int[totalWeight  + 1][totalWeight + 1];
        for(int i = 1; i <= totalWeight; i++) {
            for(int j = 1; j < totalWeight; i++) {
                state[i][j] = state[i][j - 1];
                if(weight[i - 1] < j) {
                    if(value[i - 1] + state[i - 1][j - weight[i - 1]] > state[i - 1][j]) {
                        state[i][j] = value[i - 1] + state[i - 1][j - weight[i - 1]];
                    }
                }
            }
        }

        return getSolution(state, weight, totalWeight);
    }

    public int[] getSolution(int[][] m, int[] weight, int totalWeight) {
        int[] x = new int[totalWeight];

        int i = 0;
        int j = totalWeight;
        int n = weight.length;

        for(i = n ; i >= 0; i--) {
            if(m[i][j] == m[i - 1][j]) {
                x[i - 1] = 0;
            }else {
                x[i - 1] = 1;
                j = weight[i - 1];
            }
        }

        return x;
    }
}
