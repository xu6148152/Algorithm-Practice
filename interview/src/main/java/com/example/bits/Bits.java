package com.example.bits;

/**
 * Created by binea on 2016/11/12.
 */

public class Bits {
    public int updateBits(int n, int m, int i, int j) {

        int allOnes = ~0; //1s
        int left = allOnes << (j + 1);

        int right = (1 << i) - 1;

        int mask = left | right;

        int nCleared = n & mask;
        int shifted = m << i;

        return nCleared | shifted;
    }
}
