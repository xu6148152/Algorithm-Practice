package com.binea.www.leetcodepractice.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by binea on 17/9/2017.
 */

public class PascalsTriangleII {

    /**
     * Given an index k, return the kth row of the Pascal's triangle.
     * <p>
     * For example, given k = 3,
     * Return [1,3,3,1].
     * <p>
     * Note:
     * Could you optimize your algorithm to use only O(k) extra space?
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rowResult = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            rowResult.add(0, 1);
            for (int j = 1; j < rowResult.size() - 1; j++) {
                rowResult.set(j, rowResult.get(j) + rowResult.get(j + 1));
            }
            result.add(new ArrayList<>(rowResult));
        }
        return result.get(rowIndex - 1);
    }

    public List<Integer> getRowOk(int rowIndex) {
        //C(n, k+1) = C(n, k) * (n - k) / (k + 1)
        List<Integer> nthRow = new ArrayList<>();
        if (rowIndex < 0)
            return nthRow;
        long prev = 1;
        nthRow.add((int) prev);
        for (int k = 0; k < rowIndex; k++) {
            prev = (prev * (rowIndex - k)) / (k + 1);
            nthRow.add((int) prev);
        }
        return nthRow;
    }
}
