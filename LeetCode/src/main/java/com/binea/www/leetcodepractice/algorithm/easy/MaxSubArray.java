package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 11/9/2017.
 */

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxEndingHere = 0;
        int maxTillNow = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxEndingHere = nums[i] + maxEndingHere;
            maxTillNow = maxTillNow > maxEndingHere ? maxTillNow : maxEndingHere;
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxTillNow;
    }
}
