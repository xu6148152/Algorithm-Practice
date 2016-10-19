package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 5/25/16.
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
public class MinSubArrayLen {
    /**
     *
     * Given an array of n positive integers and a positive integer s,
     * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

     * For example, given the array [2,3,1,2,4,3] and s = 7,
     * the subarray [4,3] has the minimal length under the problem constraint.

     * More practice:
     * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        return solveNLogN(s, nums);
    }

    private static int solveN(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while(end < nums.length) {
            while(end < nums.length && sum < s) sum += nums[end++];
            if(sum < s) break;
            while(start < end && sum >= s) sum -= nums[start++];
            if(end - start + 1 < minLen) minLen = end - start + 1;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] >= key){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
