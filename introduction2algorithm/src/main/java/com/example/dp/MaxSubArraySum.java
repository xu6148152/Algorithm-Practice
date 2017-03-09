package com.example.dp;

/**
 * Created by binea on 2016/10/27.
 */

public class MaxSubArraySum {

    public int getMaxSubArraySum(int[] array) {
        int n = array.length;
        if(n == 0) {
            return 0;
        }
        int start = array[0];
        for(int i = 1; i < n; i++) {
            int tmp = Math.max(array[i], array[i] + start);
            if (tmp > start){
                start = tmp;
            }
        }

        return start;
    }
}
