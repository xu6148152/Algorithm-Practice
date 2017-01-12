package com.binea.www.leetcodepractice;

import com.binea.www.leetcodepractice.algorithm.AddBinary;
import com.binea.www.leetcodepractice.algorithm.BestTimeToBuyAndSellStockII;
import com.binea.www.leetcodepractice.algorithm.CountAndSay;
import com.binea.www.leetcodepractice.algorithm.EliminationGame;
import com.binea.www.leetcodepractice.algorithm.EvalRPN;
import com.binea.www.leetcodepractice.algorithm.FirstMissingPositive;
import com.binea.www.leetcodepractice.algorithm.JumpGame;
import com.binea.www.leetcodepractice.algorithm.KSmallestPairs;
import com.binea.www.leetcodepractice.algorithm.LexicographicalNumbers;
import com.binea.www.leetcodepractice.algorithm.LongestSubString;
import com.binea.www.leetcodepractice.algorithm.MaximumProductofWordLengths;
import com.binea.www.leetcodepractice.algorithm.MinStack;
import com.binea.www.leetcodepractice.algorithm.MinSubArrayLen;
import com.binea.www.leetcodepractice.algorithm.MissingNumber;
import com.binea.www.leetcodepractice.algorithm.MoveZeros;
import com.binea.www.leetcodepractice.algorithm.PascalTriangle;
import com.binea.www.leetcodepractice.algorithm.RepeatedSubstringPattern;
import com.binea.www.leetcodepractice.algorithm.ReverseInteger;
import com.binea.www.leetcodepractice.algorithm.ReverseWords;
import com.binea.www.leetcodepractice.algorithm.SearchInsertPosition;
import com.binea.www.leetcodepractice.algorithm.SingleNumberII;
import com.binea.www.leetcodepractice.algorithm.SortColors;
import com.binea.www.leetcodepractice.algorithm.TopKFrequent;
import com.binea.www.leetcodepractice.algorithm.TwoSum;
import com.binea.www.leetcodepractice.algorithm.WordBreak;
import com.binea.www.leetcodepractice.algorithm.WordSearch;
import com.binea.www.leetcodepractice.algorithm.ZigZagConversion;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
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

    @Test public void testAddBinary() {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                b = "1";
        final String sum = AddBinary.addBinary3ms(a, b);
        System.out.print(sum);
    }

    @Test public void testJumpGame() {
        int[] A = { 2, 3, 1, 1, 4 };
        final boolean canJump = JumpGame.canJump3ms(A);
        System.out.print(canJump);
    }

    @Test public void testWaterAndJug() {
        int x = 2, y = 6, z = 5;
    }

    @Test public void testEvalRPN() {
        //String []strs = {"2", "1", "+", "3", "*"};
        String[] strs = { "4", "13", "5", "/", "+" };
        EvalRPN evalRPN = new EvalRPN();
        int result = evalRPN.evalRPN(strs);
        System.out.print(result);
    }

    @Test public void testPascalTriangle() {
        PascalTriangle pascalTriangle = new PascalTriangle();
        pascalTriangle.generate(5);
    }

    @Test public void testLexicographicalNumbers() {
        LexicographicalNumbers lexicographicalNumbers = new LexicographicalNumbers();
        List<Integer> result = lexicographicalNumbers.lexicalOrder(13);
        for (Integer i : result) {
            System.out.printf("%d ", i);
        }
    }

    @Test public void testSearchInsertPosition() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = { 1, 3, 5, 6 };
        int pos = searchInsertPosition.searchInsert(nums, 0);
        System.out.print(pos);
    }

    @Test public void testKSmallestPairs() {
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
        KSmallestPairs kSmallestPairs = new KSmallestPairs();
        final List<int[]> result = kSmallestPairs.kSmallestPairs(nums1, nums2, 3);
    }

    @Test public void testSingleNumbersII() {
        int[] nums = { 1, 2, 1, 1 };
        SingleNumberII singleNumberII = new SingleNumberII();
        int result = singleNumberII.singleNumber(nums);
        System.out.print(result);
    }

    @Test public void testSortColors() {
        SortColors sortColors = new SortColors();
        int[] nums = { 1, 0, 2, 1, 2, 0, 1, 0, 1, 2 };
        sortColors.sortColors(nums);
    }

    @Test public void testMoveZeros() {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = { 0, 1, 0, 3, 12 };
        moveZeros.moveZeros(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }

    @Test public void testRepeatedSubstringPattern() {
        String input = "a";
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        repeatedSubstringPattern.repeatedSubstringPattern(input);
    }

    @Test public void testWordSearch() {
        char[][] board = {
                { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' }
        };
        String s = "ABCCED";
        WordSearch wordSearch = new WordSearch();
        wordSearch.exist11ms(board, s);
    }

    @Test public void testMaxProductOfWordLengths() {
        String[] strs = new String[] {
                "abcw", "baz", "foo", "bar", "xtfn", "abcdef"
        };

        Assert.assertEquals(16, MaximumProductofWordLengths.maxProduct(strs));
    }

    @Test public void testEliminationGame() {
        EliminationGame eliminationGame = new EliminationGame();
        System.out.println(eliminationGame.lastRemaining(9));
    }

    @Test public void testWordBreak() {
        WordBreak wordBreak = new WordBreak();
        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");
        System.out.println(wordBreak.wordBreak(s, dict));
    }
}