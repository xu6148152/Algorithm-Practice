package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xubinggui on 5/11/16.
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 */
public class TopKFrequent {
    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * For example,
     * Given [1,1,1,2,2,3] and k = 2, return [1,2].
     *
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int n : nums) {
            int value = 0;
            if(frequencyMap.containsKey(n)) {
                value = frequencyMap.get(n);
            }
            frequencyMap.put(n, ++value);
        }

        for(int key : frequencyMap.keySet()) {
            final Integer frequence = frequencyMap.get(key);
            if(bucket[frequence] == null) {
                bucket[frequence] = new ArrayList<>();
            }
            bucket[frequence].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
