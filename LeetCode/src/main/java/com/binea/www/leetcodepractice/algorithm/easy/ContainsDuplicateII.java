package com.binea.www.leetcodepractice.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by binea on 4/10/2017.
 */

public class ContainsDuplicateII {

    /**
     * Given an array of integers and an integer k, find out whether there are two distinct indices i and j
     * in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k > 3000) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    public boolean containsNearByDuplicate0ms(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        if (k > 3000) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            int m = i + k < nums.length ? i + k : nums.length - 1;
            for (int j = i + 1; j <= m; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}
