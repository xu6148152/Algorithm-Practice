package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 10/9/2017.
 */

public class RemoveDuplicatesFromSortedArray {
    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * <p>
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * <p>
     * For example,
     * Given input array nums = [1,1,2],
     * <p>
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
