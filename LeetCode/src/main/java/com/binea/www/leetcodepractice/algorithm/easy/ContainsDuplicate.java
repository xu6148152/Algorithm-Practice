package com.binea.www.leetcodepractice.algorithm.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by finup on 30/09/2017.
 */

public class ContainsDuplicate {

    /**
     * Given an array of integers, find if the array contains any duplicates.
     * Your function should return true if any value appears at least twice in the array,
     * and it should return false if every element is distinct.
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> container = new HashSet<>();
        for (int i : nums) {
            if (container.contains(i)) {
                return true;
            }
            container.add(i);
        }
        return false;
    }

    public boolean containsDuplicate3ms(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        boolean[] flags = new boolean[max - min + 1];
        for (int i : nums) {
            int index = i - min;
            if (flags[index]) {
                return true;
            }
            flags[index] = true;
        }
        return false;
    }
}
