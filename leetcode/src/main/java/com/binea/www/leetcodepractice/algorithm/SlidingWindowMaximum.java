package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//  Created by xubinggui on 8/22/16.
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
public class SlidingWindowMaximum {

    //https://leetcode.com/problems/sliding-window-maximum/
    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see
     * the k numbers in the window. Each time the sliding window moves right by one position.
     *
     * For example,
     * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     *
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * Therefore, return the max sliding window as [3,3,5,5,6,7].
     *
     * Note:
     * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
     */
    public int[] maxSlidingWindow25ms(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public int[] maxSlidingWindow20ms(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        LinkedList<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i=0;i<nums.length;i++){
            index = i-k+1;
            if(dq.size()==0) dq.offer(i);
            while(dq.size()!=0 && nums[dq.peekLast()]<=nums[i]) dq.pollLast();
            dq.offer(i);
            while(dq.size()!=0 && dq.peekFirst()<=i-k) dq.pollFirst();
            if(index>=0) res[index] = nums[dq.peek()];
        }
        return res;
    }

    public int[] maxSlidingWindow2ms(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int n =  nums.length + 1 - k;
        int[] maxs = new int[n];
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int i = 0;
        for(i = 0; i < k; i++){
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i; // track the index for the max element
            }
        }
        int windowIndex = 0;
        maxs[windowIndex] = max;
        windowIndex++;
        int left = 0; //the index of the element we want to move out of the window
        // O(n)
        while(i < nums.length){ // i will always be window end index
            if(left != maxIndex){
                if(nums[i] >= max){
                    max = nums[i];
                    maxIndex = i;
                }
            }else{ // if max element is going to be moved out of the window, find the next max element and update maxIndex
                if(nums[i] >= nums[left]){
                    max = nums[i];
                    maxIndex = i;
                }else{
                    max = nums[left+1];
                    for(int j = left+1; j <= i; j++){ // O(k) k is constant
                        if(nums[j] >= max){
                            max = nums[j];
                            maxIndex = j;
                        }
                    }
                }
            }
            maxs[windowIndex] = max;
            windowIndex++;

            //sliding the window
            left++;
            i++;
        }
        return maxs;
    }
}
