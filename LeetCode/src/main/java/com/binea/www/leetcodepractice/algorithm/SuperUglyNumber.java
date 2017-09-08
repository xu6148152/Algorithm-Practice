package com.binea.www.leetcodepractice.algorithm;

import java.util.Arrays;

/**
 * Created by xubinggui on 5/25/16.
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 */
public class SuperUglyNumber {
    /**
     * Write a program to find the nth super ugly number.
     *
     * Super ugly numbers are positive numbers whose all prime factors
     * are in the given prime list primes of size k.
     * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
     * is the sequence of the first 12 super ugly numbers given primes =
     * [2, 7, 13, 19] of size 4.
     *
     *Note:
     *(1) 1 is a super ugly number for any given primes.
     *(2) The given numbers in primes are in ascending order.
     *(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
     * @param n
     * @param primes
     * @return
     */
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;

            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }
}
