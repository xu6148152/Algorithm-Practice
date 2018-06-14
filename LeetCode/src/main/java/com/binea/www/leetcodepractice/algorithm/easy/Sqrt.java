package com.binea.www.leetcodepractice.algorithm.easy;

import javax.swing.border.MatteBorder;

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
    public float mySqrt(float x) {
        if (x == 0)
            return 0;
        float left = 1, right = x;
        while (true) {
            float mid = left + (right - left) / 2f;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }

    public float newtonSqrt(float x) {
        float r = x;
        while (Math.abs(r * r - x) > 1e-9)
            r = (r + x / r) / 2f;
        return r;
    }
}
