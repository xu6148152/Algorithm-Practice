package com.example;

import java.util.Arrays;

/**
 * Created by binea on 8/9/2017.
 */

public class LongestIncreasingArray {
    /**
     * @param array
     */
    public int[] getLongestIncreasingArray(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }

        int maxLength = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && result[j] + 1 > result[i]) {
                    result[i] = result[j] + 1;
                }

                if (maxLength < result[i]) {
                    maxLength = result[i];
                }
            }
        }

        return result;
    }

    public int getLongestIncreasingArray1ms(int[] array) {
        int[] tails = new int[array.length];
        int size = 0;

        for (int x : array) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    public int[] getLongestIncreasingArrayDp(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return dp;
    }
}
