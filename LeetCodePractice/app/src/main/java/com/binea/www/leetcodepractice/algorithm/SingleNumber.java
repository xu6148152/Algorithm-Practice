package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 9/21/16.
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

public class SingleNumber {

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     *
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
