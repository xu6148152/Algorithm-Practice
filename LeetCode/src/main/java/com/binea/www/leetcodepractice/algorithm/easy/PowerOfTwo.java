package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 5/10/2017.
 */

public class PowerOfTwo {

    /**
     * Given an integer, write a function to determine if it is a power of two.
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }

        return isPowerOfTwo(n / 2);
    }

    public boolean isPowerOfTwo1ms(int n) {
        return n > 0 && ((n & n - 1) == 0);
    }
}
