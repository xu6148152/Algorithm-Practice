package com.binea.www.leetcodepractice.algorithm.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by binea on 20/9/2017.
 */

public class TwoSumII {

    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     * <p>
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * <p>
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * <p>
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int remain = target - numbers[i];
            if (map.containsKey(remain)) {
                result[0] = map.get(remain);
                result[1] = i + 1;
                break;
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return result;
    }

    public int[] twoSum0ms(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int p1 = 0;
        int p2 = numbers.length - 1;
        while (p1 < p2) {
            int sum = numbers[p1] + numbers[p2];
            if (sum < target) {
                int binarySearchP1 = Arrays.binarySearch(numbers, p1 + 1, p2 - 1, target - numbers[p2]);
                p1 = binarySearchP1 >= 0 ? binarySearchP1 : -(binarySearchP1 + 1);
            } else if (sum > target) {
                int binarySearchP2 = Arrays.binarySearch(numbers, p1 + 1, p2 - 1, target - numbers[p1]);
                p2 = binarySearchP2 >= 0 ? binarySearchP2 : -(binarySearchP2 + 1);
            } else {
                return new int[]{p1, p2};
            }
        }

        throw new RuntimeException();
    }
}
