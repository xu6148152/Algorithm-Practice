package com.example.dp;

/**
 * Created by binea on 2016/10/19.
 */

public class Fab {
    public static int getFab(int n) {
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for(int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }
}
