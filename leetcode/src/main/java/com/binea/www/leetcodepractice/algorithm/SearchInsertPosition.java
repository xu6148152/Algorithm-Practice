package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 02/11/2016.
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

public class SearchInsertPosition {

    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were
     * inserted in order.
     *
     * You may assume no duplicates in the array.
     *
     * Here are few examples.
     * [1,3,5,6], 5 → 2
     * [1,3,5,6], 2 → 1
     * [1,3,5,6], 7 → 4
     * [1,3,5,6], 0 → 0
     */
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        if (target <= nums[0]) {
            return 0;
        }

        int head = 0;
        int end = nums.length - 1;
        while (head <= end) {
            int mid = head + (end - head) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                if (nums[mid + 1] > target) {
                    return mid + 1;
                } else {
                    head = mid + 1;
                }
            } else {
                if (nums[mid - 1] < target) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return end;
    }
}
