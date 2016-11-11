package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 11/11/2016.
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

public class RemoveDuplicateII {

    /**
     * Follow up for "Remove Duplicates":
     * What if duplicates are allowed at most twice?
     *
     * For example,
     * Given sorted array nums = [1,1,1,2,2,3],
     *
     * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond
     * the new length.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        final int N = nums.length;
        int p = 2;
        for (int i = 2; i < N; i++) {
            if (nums[i] > nums[p - 2]) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}
