package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 14/9/2017.
 */

public class Sqrt {

    /**
     * Implement int sqrt(int x).
     * <p>
     * Compute and return the square root of x.
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
