package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xubinggui on 1/6/16.
 */
public class TwoSum {
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
