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

    public int getNext(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        int p = c0 + c1;
        n |= (1 << p);
        n &= ~((1 << p) - 1);
        n |= (1 << (c1 - 1)) - 1;

        return n;
    }

    public int getPrev(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }

        if (temp == 0) {
            return -1;
        }

        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }

        int p = c0 + c1;
        n *= ((~0) << (p + 1));

        int mask = (1 << (c1 + 1)) - 1;
        n |= mask << (c0 - 1);
        return n;
    }

    public int getNextArith(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        return n + (1 << c0) + (1 << (c1 - 1)) - 1;
    }

    public int getPreArith(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }

        if (temp == 0) {
            return -1;
        }

        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>= 1;
        }

        return n - (1 << c1) - (1 << (c0 - 1)) + 1;
    }

    public int bitSwapRequired1(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c >>= 1) {
            count++;
        }
        return count;
    }

    public int bitSwapRequired2(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c &= (c - 1)) {
            count++;
        }
        return count;
    }
}
