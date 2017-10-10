package com.binea.www.leetcodepractice.algorithm.easy;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by binea on 10/10/2017.
 */

public class UglyNumber {

    /**
     * Write a program to check whether a given number is an ugly number.
     * <p>
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
     * <p>
     * Note that 1 is typically treated as an ugly number.
     *
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
