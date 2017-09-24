package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 24/9/2017.
 */

public class MajorityElement {

    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * <p>
     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int majority = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count++;
                majority = nums[i];
            } else if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}
