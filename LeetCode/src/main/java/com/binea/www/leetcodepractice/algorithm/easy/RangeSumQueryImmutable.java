package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 18/10/2017.
 */

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public class RangeSumQueryImmutable {

    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
