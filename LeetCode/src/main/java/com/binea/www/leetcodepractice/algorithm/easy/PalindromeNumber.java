package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by xubinggui on 9/8/17.
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        int origin = x;
        int revert = 0;
        while (origin > revert) {
            revert = revert * 10 + origin % 10;
            origin /= 10;
        }

        return origin == revert || revert / 10 == origin;
    }
}
