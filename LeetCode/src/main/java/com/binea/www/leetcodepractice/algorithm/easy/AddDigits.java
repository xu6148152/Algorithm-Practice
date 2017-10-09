package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 9/10/2017.
 */

public class AddDigits {

    /**
     * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * <p>
     * For example:
     * <p>
     * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     * <p>
     * Follow up:
     * Could you do it without any loop/recursion in O(1) runtime?
     * <p>
     * Credits:
     * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
