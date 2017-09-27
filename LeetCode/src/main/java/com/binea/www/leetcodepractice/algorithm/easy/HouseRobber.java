package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 27/9/2017.
 */

public class HouseRobber {

    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
     * it will automatically contact the police if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can
     * rob tonight without alerting the police.
     *
     * @param nums
     * @return
     */
    public int robDp(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    public int rob(int[] nums) {
        int preNo = 0;
        int preYes = 0;
        for (int i : nums) {
            int tmp = preNo;
            preNo = Math.max(preNo, preYes);
            preYes = i + tmp;
        }
        return Math.max(preNo, preYes);
    }
}
