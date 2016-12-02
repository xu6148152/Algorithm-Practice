package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 02/12/2016.
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

import java.util.Arrays;

public class MinMoves2 {

    /**
     * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a
     * selected element by 1 or decrementing a selected element by 1.
     *
     * You may assume the array's length is at most 10,000.
     *
     * Example:
     *
     * Input:
     * [1,2,3]
     *
     * Output:
     * 2
     *
     * Explanation:
     * Only two moves are needed (remember each move increments or decrements one element):
     *
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int moveCount = 0;
        while (i < j) {
            moveCount += nums[j] - nums[i];
            i++;
            j--;
        }
        return moveCount;
    }
}
