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

    public String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(".");
        while (num > 0) {
            if (sb.length() >= 32) {
                return "ERROR";
            }
            double r = num * 2;
            if (r >= 1) {
                sb.append(1);
                num = r - 1;
            } else {
                sb.append(0);
                num = r;
            }
        }
        return sb.toString();
    }
}
