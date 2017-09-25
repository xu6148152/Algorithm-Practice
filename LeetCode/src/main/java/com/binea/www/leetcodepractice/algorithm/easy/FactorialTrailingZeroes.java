package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 25/9/2017.
 */

public class FactorialTrailingZeroes {

    /**
     * Given an integer n, return the number of trailing zeroes in n!.
     * <p>
     * Note: Your solution should be in logarithmic time complexity.
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? n : n / 5 + trailingZeroes(n / 5);
    }
}
