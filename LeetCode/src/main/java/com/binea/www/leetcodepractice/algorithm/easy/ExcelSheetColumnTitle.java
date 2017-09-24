package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 24/9/2017.
 */

public class ExcelSheetColumnTitle {

    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     * <p>
     * For example:
     * <p>
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }
}
