package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 7/21/16.
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
public class LargestRectangleArea {

    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in
     * the histogram.
     *
     *
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     *
     *
     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     *
     * For example,
     * Given heights = [2,1,5,6,2,3],
     * return 10.
     */

    public int largestRectangleArea6ms(int[] h) {
        int n = h.length;
        int max = 0;
        int[] stack = new int[n + 1];
        int is = -1;
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : h[i];
            while (is != -1 && height < h[stack[is]]) {
                int hh = h[stack[is--]];
                int width = (is == -1) ? i : i - 1 - stack[is];
                max = Math.max(max, hh * width);
            }
            stack[++is] = i;
        }
        return max;
    }

    public int largestRectangleArea4ms(int[] height) {
        if ((height == null) || (height.length == 0)) return 0;
        final int N = height.length;
        int[] s = new int[N + 1];
        int i, top = 0, hi, area = 0;
        s[0] = -1;
        for (i = 0; i < N; i++) {
            hi = height[i];
            while ((top > 0) && (height[s[top]] > hi)) {
                area = Math.max(area, height[s[top]] * (i - s[top - 1] - 1));
                top--;
            }
            s[++top] = i;
        }
        while (top > 0) {
            area = Math.max(area, height[s[top]] * (N - s[top -1] - 1));
            top--;
        }
        return area;
    }
}
