package com.binea.www.leetcodepractice.algorithm;

//   Created by binea on 14/2/2017.
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

public class FindMinimumInRotatedSortedArrayII {

    /**
     * Follow up for "Find Minimum in Rotated Sorted Array":
     * What if duplicates are allowed?
     * <p>
     * Would this affect the run-time complexity? How and why?
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * <p>
     * Find the minimum element.
     * <p>
     * The array may contain duplicates.
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[mid] < nums[h]) {
                h = mid;
            } else if (nums[mid] > nums[h]) {
                l = mid + 1;
            } else {
                h--;
            }
        }
        return nums[l];
    }
}
