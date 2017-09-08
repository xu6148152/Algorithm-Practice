package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xubinggui on 1/6/16.
 */
public class TwoSum {
    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.

       The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

       You may assume that each input would have exactly one solution.

       Input: numbers={2, 7, 11, 15}, target=9
       Output: index1=1, index2=2
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!m.containsKey(nums[i])) {
                m.put(target - nums[i], i);
            }else {
                result.add(m.get(nums[i]) + 1);
                result.add(i + 1);
                break;
            }
        }
        int[] tmp = new int[result.size()];
        for(int i = 0; i < tmp.length; i++) {
            tmp[i] = result.get(i);
        }
        return tmp;
    }
}
