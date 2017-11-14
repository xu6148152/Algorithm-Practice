package com.binea.www.leetcodepractice.algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by binea on 14/11/2017.
 */

public class IntersectionofTwoArrays {

    /**
     * Given two arrays, write a function to compute their intersection.
     * <p>
     * Example:
     * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
     * <p>
     * Note:
     * Each element in the result must be unique.
     * The result can be in any order.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(set::contains).toArray();
    }

    public int[] intersectionFaster(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        List<Integer> res = new ArrayList<>();
        int max = nums1[0], min = max;

        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] > max) max = nums1[i];
            else if (nums1[i] < min) min = nums1[i];
        }

        boolean[] bucket = new boolean[max - min + 1];

        for (int num : nums1) bucket[num - min] = true;

        for (int num : nums2) {
            if (num >= min && num <= max) {
                if (bucket[num - min]) {
                    res.add(num);
                    bucket[num - min] = false;
                }
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
