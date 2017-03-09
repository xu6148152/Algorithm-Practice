package com.binea.www.leetcodepractice.algorithm;

import java.util.Arrays;

//  Created by xubinggui on 9/9/16.
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易 
public class LengthOfLIS {
    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     *
     * For example,
     * Given [10, 9, 2, 5, 3, 7, 101, 18],
     * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is
     * only necessary for you to return the length.
     *
     * Your algorithm should run in O(n2) complexity.
     *
     * Follow up: Could you improve it to O(n log n) time complexity?
     */
    public int lengthOfLIS3ms(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if (i == len) {
                len++;
            }
        }

        return len;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] tails = new int[nums.length];
        int max = 0;
        tails[max] = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= tails[0]) {
                tails[0] = nums[i];
            } else if (nums[i] >= tails[max]) {
                tails[++max] = nums[i];
            } else {
                tails[binarySearch(0, max, tails, nums[i])] = nums[i];
            }
        }

        return max + 1;
    }

    public int binarySearch(int L, int R, int[] tails, int target) {
        while (L <= R) {
            int M = L + (R - L) / 2;

            if (target > tails[M]) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }

        return L;
    }
}
