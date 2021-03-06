package com.binea.www.leetcodepractice;

import com.binea.www.leetcodepractice.algorithm.AddBinary;
import com.binea.www.leetcodepractice.algorithm.BestTimeToBuyAndSellStockII;
import com.binea.www.leetcodepractice.algorithm.CountAndSay;
import com.binea.www.leetcodepractice.algorithm.EliminationGame;
import com.binea.www.leetcodepractice.algorithm.EvalRPN;
import com.binea.www.leetcodepractice.algorithm.FindMinimumInRotatedSortedArrayII;
import com.binea.www.leetcodepractice.algorithm.FirstMissingPositive;
import com.binea.www.leetcodepractice.algorithm.JumpGame;
import com.binea.www.leetcodepractice.algorithm.KSmallestPairs;
import com.binea.www.leetcodepractice.algorithm.LexicographicalNumbers;
import com.binea.www.leetcodepractice.algorithm.ListNode;
import com.binea.www.leetcodepractice.algorithm.LongestSubString;
import com.binea.www.leetcodepractice.algorithm.MaxSumOfRectangeNoLargerThanK;
import com.binea.www.leetcodepractice.algorithm.MaximumProductofWordLengths;
import com.binea.www.leetcodepractice.algorithm.MinStack;
import com.binea.www.leetcodepractice.algorithm.MinSubArrayLen;
import com.binea.www.leetcodepractice.algorithm.MinimumWindowSubstring;
import com.binea.www.leetcodepractice.algorithm.MissingNumber;
import com.binea.www.leetcodepractice.algorithm.MoveZeros;
import com.binea.www.leetcodepractice.algorithm.PascalTriangle;
import com.binea.www.leetcodepractice.algorithm.RepeatedSubstringPattern;
import com.binea.www.leetcodepractice.algorithm.ReverseInteger;
import com.binea.www.leetcodepractice.algorithm.ReverseWords;
import com.binea.www.leetcodepractice.algorithm.SearchInsertPosition;
import com.binea.www.leetcodepractice.algorithm.SingleNumber;
import com.binea.www.leetcodepractice.algorithm.SingleNumberII;
import com.binea.www.leetcodepractice.algorithm.SortColors;
import com.binea.www.leetcodepractice.algorithm.TopKFrequent;
import com.binea.www.leetcodepractice.algorithm.TwoSum;
import com.binea.www.leetcodepractice.algorithm.WordBreak;
import com.binea.www.leetcodepractice.algorithm.WordSearch;
import com.binea.www.leetcodepractice.algorithm.ZigZagConversion;
import com.binea.www.leetcodepractice.algorithm.easy.AddDigits;
import com.binea.www.leetcodepractice.algorithm.easy.BestTimetoBuyandSellStock;
import com.binea.www.leetcodepractice.algorithm.easy.DeleteNodeInALinkedList;
import com.binea.www.leetcodepractice.algorithm.easy.ExcelSheetColumnTitle;
import com.binea.www.leetcodepractice.algorithm.easy.FirstBadVersion;
import com.binea.www.leetcodepractice.algorithm.easy.IntersectionofTwoArrays;
import com.binea.www.leetcodepractice.algorithm.easy.MaxSubArray;
import com.binea.www.leetcodepractice.algorithm.easy.NimGame;
import com.binea.www.leetcodepractice.algorithm.easy.NonDecreasingArray;
import com.binea.www.leetcodepractice.algorithm.easy.PalindromeLinkedList;
import com.binea.www.leetcodepractice.algorithm.easy.PalindromeNumber;
import com.binea.www.leetcodepractice.algorithm.easy.PascalsTriangleII;
import com.binea.www.leetcodepractice.algorithm.easy.PlusOne;
import com.binea.www.leetcodepractice.algorithm.easy.PowerOfTwo;
import com.binea.www.leetcodepractice.algorithm.easy.RangeSumQueryImmutable;
import com.binea.www.leetcodepractice.algorithm.easy.RemoveDuplicatesFromSortedArray;
import com.binea.www.leetcodepractice.algorithm.easy.ReverseBits;
import com.binea.www.leetcodepractice.algorithm.easy.ReverseString;
import com.binea.www.leetcodepractice.algorithm.easy.ReverseVowelsOfAString;
import com.binea.www.leetcodepractice.algorithm.easy.RotateArray;
import com.binea.www.leetcodepractice.algorithm.easy.Sqrt;
import com.binea.www.leetcodepractice.algorithm.easy.StrStr;
import com.binea.www.leetcodepractice.algorithm.easy.TwoSumII;
import com.binea.www.leetcodepractice.algorithm.easy.UglyNumber;
import com.binea.www.leetcodepractice.algorithm.easy.ValidAnagram;
import com.binea.www.leetcodepractice.algorithm.easy.ValidParentheses;
import com.binea.www.leetcodepractice.algorithm.easy.WordPattern;
import com.binea.www.leetcodepractice.algorithm.hard.MedianOfTwoSortedArrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UnitTest {

    @Test
    public void testTwoSum() {
        int[] numbers = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        final int[] ints = twoSum.twoSum(numbers, 13);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    @Test
    public void testLongestSubString() {
        String s = "abcabcabd";
        LongestSubString lss = new LongestSubString();
        System.out.print(lss.lengthOfLongestSubstring(s));
    }

    @Test
    public void testTopKFrequent() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> results = TopKFrequent.topKFrequent(nums, k);
        System.out.print(results.toString());
    }

    @Test
    public void testMaxProfit() {
        int[] prices = {100, 200, 150, 180, 300};
        int profit = BestTimeToBuyAndSellStockII.maxProfit(prices);
        System.out.print(profit);
    }

    @Test
    public void testCountAndSay() {
        int nums = 20;
        String result = CountAndSay.countAndSay(nums);
        System.out.print(result);
    }

    @Test
    public void testFirstMissingPositive() {
        int[] nums = {3, 4, -1, 1};
        //int[] nums = {1,2,0};
        //int[] nums = {2};
        int value = FirstMissingPositive.firstMissingPositive(nums);
        System.out.print(value);
    }

    @Test
    public void testReverseInteger() {
        int value = -123;
        int result = ReverseInteger.reverse(value);
        System.out.print(result);
    }

    @Test
    public void testMinSubArrayLen() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int len = MinSubArrayLen.minSubArrayLen(7, nums);
        System.out.print(len);
    }

    @Test
    public void testZigZagConversion() {
        String text = "PAYPALISHIRING";
        String result = ZigZagConversion.convert14ms(text, 3);
        System.out.print(result);
    }

    @Test
    public void testReverseWords() {
        //String text = "the sky is blue";
        String text = "   a   b ";
        String result = ReverseWords.reverseWords14ms(text);
        System.out.print(result);
    }

    @Test
    public void testMissingNumber() {
        int[] a = {0, 1, 3};
        int result = MissingNumber.missingNumber(a);
        System.out.print(result);
    }

    @Test
    public void testMinStack() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("minValue " + minStack.getMin());
        minStack.pop();
        System.out.println("topValue " + minStack.top());
        System.out.println("minValue " + minStack.getMin());
    }

    @Test
    public void testAddBinary() {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                b = "1";
        final String sum = AddBinary.addBinary3ms(a, b);
        System.out.print(sum);
    }

    @Test
    public void testJumpGame() {
        int[] A = {2, 3, 1, 1, 4};
        final boolean canJump = JumpGame.canJump3ms(A);
        System.out.print(canJump);
    }

    @Test
    public void testWaterAndJug() {
        int x = 2, y = 6, z = 5;
    }

    @Test
    public void testEvalRPN() {
        //String []strs = {"2", "1", "+", "3", "*"};
        String[] strs = {"4", "13", "5", "/", "+"};
        EvalRPN evalRPN = new EvalRPN();
        int result = evalRPN.evalRPN(strs);
        System.out.print(result);
    }

    @Test
    public void testPascalTriangle() {
        PascalTriangle pascalTriangle = new PascalTriangle();
        pascalTriangle.generate(5);
    }

    @Test
    public void testLexicographicalNumbers() {
        LexicographicalNumbers lexicographicalNumbers = new LexicographicalNumbers();
        List<Integer> result = lexicographicalNumbers.lexicalOrder(13);
        for (Integer i : result) {
            System.out.printf("%d ", i);
        }
    }

    @Test
    public void testSearchInsertPosition() {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int pos = searchInsertPosition.searchInsert(nums, 0);
        System.out.print(pos);
    }

    @Test
    public void testKSmallestPairs() {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        KSmallestPairs kSmallestPairs = new KSmallestPairs();
        final List<int[]> result = kSmallestPairs.kSmallestPairs(nums1, nums2, 3);
    }

    @Test
    public void testSingleNumbersII() {
        int[] nums = {1, 2, 1, 1};
        SingleNumberII singleNumberII = new SingleNumberII();
        int result = singleNumberII.singleNumber(nums);
        System.out.print(result);
    }

    @Test
    public void testSortColors() {
        SortColors sortColors = new SortColors();
        int[] nums = {1, 0, 2, 1, 2, 0, 1, 0, 1, 2};
        sortColors.sortColors(nums);
    }

    @Test
    public void testMoveZeros() {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros.moveZeros(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }

    @Test
    public void testRepeatedSubstringPattern() {
        String input = "a";
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        repeatedSubstringPattern.repeatedSubstringPattern(input);
    }

    @Test
    public void testWordSearch() {
        char[][] board = {
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        String s = "ABCCED";
        WordSearch wordSearch = new WordSearch();
        wordSearch.exist11ms(board, s);
    }

    @Test
    public void testMaxProductOfWordLengths() {
        String[] strs = new String[]{
                "abcw", "baz", "foo", "bar", "xtfn", "abcdef"
        };

        Assert.assertEquals(16, MaximumProductofWordLengths.maxProduct(strs));
    }

    @Test
    public void testEliminationGame() {
        EliminationGame eliminationGame = new EliminationGame();
        System.out.println(eliminationGame.lastRemaining(9));
    }

    @Test
    public void testWordBreak() {
        WordBreak wordBreak = new WordBreak();
        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");
        System.out.println(wordBreak.wordBreak(s, dict));
    }

    @Test
    public void testMinimumWindowSubstring() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        long startTime = System.currentTimeMillis();
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        minimumWindowSubstring.minWindow(s, t);
        long endTime = System.currentTimeMillis();
        System.out.printf("run time: %d", endTime - startTime);
        System.out.println();
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

    @Test
    public void testFindMinInRotatedSortedArrayII() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        FindMinimumInRotatedSortedArrayII minimumInRotatedSortedArrayII = new FindMinimumInRotatedSortedArrayII();
        int minNum = minimumInRotatedSortedArrayII.findMin(nums);
        System.out.print(minNum);
    }

    @Test
    public void testMaxSumOfRectangleNoLargerThanK() {
        MaxSumOfRectangeNoLargerThanK mso = new MaxSumOfRectangeNoLargerThanK();
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3}
        };
        long start = System.currentTimeMillis();
        int result = mso.maxSumSubmatrix(matrix, 2);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.printf("%d ms", end - start);

    }

    @Test
    public void testInteger() {
        int a = 1000;
        Integer b = 1000;
        System.out.print(a == b);
    }

    @Test
    public void testPalindrome() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        palindromeNumber.isPalindrome(121);
    }

    @Test
    public void testValidParentheses() {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("((([])[]))"));
    }

    @Test
    public void testRemoveDuplicatesFromSortedArray() {
        RemoveDuplicatesFromSortedArray array = new RemoveDuplicatesFromSortedArray();
        int[] a = {1, 1, 2};
        System.out.print(array.removeDuplicates(a));
    }

    @Test
    public void testStrStr() {
        StrStr strStr = new StrStr();
        String hayStack = "mississippi";
        String needle = "issip";
        System.out.print(strStr.strStr(hayStack, needle));
    }

    @Test
    public void testMaxSubArray() {
        MaxSubArray msa = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.print(msa.maxSubArray(nums));
    }

    @Test
    public void testAddPlus() {
        int[] digits = {9, 9};
        PlusOne plusOne = new PlusOne();
        plusOne.plusOne(digits);
    }

    @Test
    public void testSqrt() {
        Sqrt sqrt = new Sqrt();
        System.out.print(sqrt.mySqrt(3));
//        System.out.println();
//        System.out.println(sqrt.newtonSqrt(3));
    }

    @Test
    public void testPascalTriangleII() {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        List<Integer> result = pascalsTriangleII.getRowOk(3);
        for (Integer integer : result) {
            System.out.print(integer);
        }
    }

    @Test
    public void testBestTimeToBuyAndSellStock() {
        BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new BestTimetoBuyandSellStock();
//        int[] stocks = {7, 1, 5, 3, 6, 4};
        int[] stocks = {7, 6, 4, 3, 1};
        int maxProfit = bestTimetoBuyandSellStock.maxProfit(stocks);
        System.out.print(maxProfit);
    }

    @Test
    public void testSingleNumber() {
        int[] nums = {0, 1, 0};
        SingleNumber singleNumber = new SingleNumber();
        System.out.print(singleNumber.singleNumber(nums));
    }

    @Test
    public void testTwoSumII() {
        int[] nums = {2, 7, 11, 15};
        TwoSumII twoSumII = new TwoSumII();
        int[] results = twoSumII.twoSum(nums, 9);
        for (int i : results) {
            System.out.println(i);
        }
    }

    @Test
    public void testExcelSheetColumnTitle() {
        int n = 26;
        ExcelSheetColumnTitle title = new ExcelSheetColumnTitle();
        System.out.println(title.convertToTitle(n));
    }

    @Test
    public void testRotateArray() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotateReverse(nums, 3);
        for (int i : nums) {
            System.out.print(i);
        }
    }

    @Test
    public void testReverseBits() {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits1ms(43261596));
    }

    @Test
    public void testPowerOfTwo() {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(1022));
    }

    @Test
    public void testPalindromeLinkedList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(-129);
        head.next.next = new ListNode(-230);
        head.next.next.next = new ListNode(-230);
        head.next.next.next.next = new ListNode(-129);
        head.next.next.next.next.next = new ListNode(1);
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(head));
    }

    @Test
    public void testDeleteNodeInALinkedList() {
        ListNode oneNode = new ListNode(1);
        ListNode twoNode = new ListNode(2);
        oneNode.next = twoNode;
        oneNode.next.next = new ListNode(3);
        oneNode.next.next.next = new ListNode(4);

        DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();
        deleteNodeInALinkedList.deleteNode(oneNode, twoNode);
    }

    @Test
    public void testValidAnagram() {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.print(validAnagram.isAnagram(s, t));
    }

    @Test
    public void testAddDigits() {
        AddDigits addDigits = new AddDigits();
        int num = 38;
        System.out.print(addDigits.addDigits(num));
    }

    @Test
    public void testUglyNumber() {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(8));
        System.out.println(uglyNumber.isUgly(14));
    }

    @Test
    public void testFistBadVersion() {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.print(firstBadVersion.firstBadVersion(3));
    }

    @Test
    public void testWordPattern() {
        WordPattern wordPattern = new WordPattern();
        System.out.print(wordPattern.wordPattern("abc", "b c a"));
    }

    @Test
    public void testNimGame() {
        NimGame nimGame = new NimGame();
        System.out.print(nimGame.canWinNim(4));
    }

    @Test
    public void testRangeSumQueryImmutable() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(nums);
        System.out.println(rangeSumQueryImmutable.sumRange(0, 2));
    }

    @Test
    public void testReverseString() {
        ReverseString reverseString = new ReverseString();
        System.out.print(reverseString.reverseString("hello"));
    }

    @Test
    public void testReverseVowelsOfStrings() {
        ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();
        String result = reverseVowelsOfAString.reverseVowels("leetcode");
        System.out.print(result);
    }

    @Test
    public void testIntersectionofTwoArrays() {
        IntersectionofTwoArrays intersectionofTwoArrays = new IntersectionofTwoArrays();
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {2, 4};
        int[] intersection = intersectionofTwoArrays.intersection(nums1, nums2);
        Arrays.stream(intersection).forEach(System.out::print);
    }

    @Test
    public void testNonDecreasingArray() {
        int[] nums = {1, 2, 3, 0};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean ret = nonDecreasingArray.checkPossibility(nums);
        System.out.println(ret);
    }

    @Test
    public void testMedianOfTwoSortedArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double median = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}