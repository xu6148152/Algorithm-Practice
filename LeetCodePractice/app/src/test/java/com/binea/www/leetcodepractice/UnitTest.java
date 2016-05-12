package com.binea.www.leetcodepractice;

import com.binea.www.leetcodepractice.algorithm.BestTimeToBuyAndSellStockII;
import com.binea.www.leetcodepractice.algorithm.CountAndSay;
import com.binea.www.leetcodepractice.algorithm.LongestSubString;
import com.binea.www.leetcodepractice.algorithm.TopKFrequent;
import com.binea.www.leetcodepractice.algorithm.TwoSum;
import java.util.List;
import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UnitTest {

    @Test public void testTwoSum() {
        int[] numbers = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        final int[] ints = twoSum.twoSum(numbers, 13);
        for(int i = 0;i<ints.length;i++){
            System.out.print(ints[i] + " ");
        }
    }

    @Test public void testLongestSubString() {
        String s = "abcabcabd";
        LongestSubString lss = new LongestSubString();
        System.out.print(lss.lengthOfLongestSubstring(s));
    }

    @Test public void testTopKFrequent() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> results = TopKFrequent.topKFrequent(nums, k);
        System.out.print(results.toString());
    }

    @Test public void testMaxProfit() {
        int[] prices = {100, 200, 150, 180, 300};
        int profit = BestTimeToBuyAndSellStockII.maxProfit(prices);
        System.out.print(profit);
    }

    @Test public void testCountAndSay() {
        int nums = 20;
        String result = CountAndSay.countAndSay(nums);
        System.out.print(result);
    }
}