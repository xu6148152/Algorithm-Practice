package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 01/11/2016.
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

import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem {

    /**
     * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you
     * are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed
     * by these buildings collectively (Figure B).
     *
     *
     * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the
     * left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and
     * Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
     *
     * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
     *
     * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a
     * skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is
     * merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should
     * be considered part of the skyline contour.
     *
     * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
     *
     * Notes:
     *
     * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
     * The input list is already sorted in ascending order by the left x position Li.
     * The output list must be sorted by the x position.
     * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...]
     * is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
     */
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0) {
            return result;
        }
        return computeSkyline(buildings, 0, buildings.length - 1);
    }

    public static int[] getPoint(int x, int y) {
        int[] temp = { x, y };
        return temp;
    }

    private static List<int[]> computeSkyline(int[][] buildings, int from, int to) {
        List<int[]> result = new ArrayList<int[]>();
        if (from == to) {
            result.add(getPoint(buildings[from][0], buildings[from][2]));
            result.add(getPoint(buildings[from][1], 0));
            return result;
        }
        int mid = from + (to - from) / 2;
        List<int[]> LS1 = computeSkyline(buildings, from, mid);
        List<int[]> LS2 = computeSkyline(buildings, mid + 1, to);
        return merge(LS1, LS2);
    }

    public static List<int[]> merge(List<int[]> SL1, List<int[]> SL2) {
        List<int[]> result = new ArrayList<int[]>();
        int len1 = SL1.size(), len2 = SL2.size();
        int p1 = 0, p2 = 0, H1 = 0, H2 = 0;
        int[] cur = null;
        // A boolean parameter to record whether the cur value is from
        // SL1 or SL2
        boolean fromSL1 = true;
        while (p1 < len1 && p2 < len2) {
            int[] s1 = SL1.get(p1);
            int[] s2 = SL2.get(p2);
            if (s1[0] < s2[0]) {
                fromSL1 = true;
                cur = s1;
                H1 = cur[1];
                ++p1;
            } else if (s1[0] > s2[0]) {
                fromSL1 = false;
                cur = s2;
                H2 = cur[1];
                ++p2;
            } else {
                if (s1[1] > s2[1]) {
                    fromSL1 = true;
                    cur = s1;
                } else {
                    fromSL1 = false;
                    cur = s2;
                }
                H1 = s1[1];
                H2 = s2[1];
                ++p1;
                ++p2;
            }
            int h = 0;
            if (fromSL1) {
                h = Math.max(cur[1], H2);
            } else {
                h = Math.max(cur[1], H1);
            }
            if (result.isEmpty() || h != result.get(result.size() - 1)[1]) {
                result.add(getPoint(cur[0], h));
            }
        }

        while (p1 < len1) {
            result.add(SL1.get(p1++));
        }
        while (p2 < len2) {
            result.add(SL2.get(p2++));
        }

        return result;
    }
}
