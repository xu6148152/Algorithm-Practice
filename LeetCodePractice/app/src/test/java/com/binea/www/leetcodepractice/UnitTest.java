package com.binea.www.leetcodepractice;

import com.binea.www.leetcodepractice.algorithm.BestTimeToBuyAndSellStockII;
import com.binea.www.leetcodepractice.algorithm.CountAndSay;
import com.binea.www.leetcodepractice.algorithm.FirstMissingPositive;
import com.binea.www.leetcodepractice.algorithm.LongestSubString;
import com.binea.www.leetcodepractice.algorithm.MinStack;
import com.binea.www.leetcodepractice.algorithm.MinSubArrayLen;
import com.binea.www.leetcodepractice.algorithm.MissingNumber;
import com.binea.www.leetcodepractice.algorithm.ReverseInteger;
import com.binea.www.leetcodepractice.algorithm.ReverseWords;
import com.binea.www.leetcodepractice.algorithm.TopKFrequent;
import com.binea.www.leetcodepractice.algorithm.TwoSum;
import com.binea.www.leetcodepractice.algorithm.ZigZagConversion;
import java.util.List;
import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UnitTest {

    @Test public void testTwoSum() {
        int[] numbers = { 2, 7, 11, 15 };
        TwoSum twoSum = new TwoSum();
        final int[] ints = twoSum.twoSum(numbers, 13);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    @Test public void testLongestSubString() {
        String s = "abcabcabd";
        LongestSubString lss = new LongestSubString();
        System.out.print(lss.lengthOfLongestSubstring(s));
    }

    @Test public void testTopKFrequent() {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        List<Integer> results = TopKFrequent.topKFrequent(nums, k);
        System.out.print(results.toString());
    }

    @Test public void testMaxProfit() {
        int[] prices = { 100, 200, 150, 180, 300 };
        int profit = BestTimeToBuyAndSellStockII.maxProfit(prices);
        System.out.print(profit);
    }

    @Test public void testCountAndSay() {
        int nums = 20;
        String result = CountAndSay.countAndSay(nums);
        System.out.print(result);
    }

    @Test public void testFirstMissingPositive() {
        int[] nums = { 3, 4, -1, 1 };
        //int[] nums = {1,2,0};
        //int[] nums = {2};
        int value = FirstMissingPositive.firstMissingPositive(nums);
        System.out.print(value);
    }

    @Test public void testReverseInteger() {
        int value = -123;
        int result = ReverseInteger.reverse(value);
        System.out.print(result);
    }

    @Test public void testMinSubArrayLen() {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int len = MinSubArrayLen.minSubArrayLen(7, nums);
        System.out.print(len);
    }

    @Test public void testZigZagConversion() {
        String text = "PAYPALISHIRING";
        String result = ZigZagConversion.convert14ms(text, 3);
        System.out.print(result);
    }

    @Test public void testReverseWords() {
        //String text = "the sky is blue";
        String text = "   a   b ";
        String result = ReverseWords.reverseWords14ms(text);
        System.out.print(result);
    }

    @Test public void testMissingNumber() {
        int[] a = { 0, 1, 3 };
        int result = MissingNumber.missingNumber(a);
        System.out.print(result);
    }

    @Test public void testMinStack() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("minValue " + minStack.getMin());
        minStack.pop();
        System.out.println("topValue " + minStack.top());
        System.out.println("minValue " + minStack.getMin());
    }
}