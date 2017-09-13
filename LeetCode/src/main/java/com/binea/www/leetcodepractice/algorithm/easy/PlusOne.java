package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 13/9/2017.
 */

public class PlusOne {

    /**
     * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
     * <p>
     * You may assume the integer do not contain any leading zero, except the number 0 itself.
     * <p>
     * The digits are stored such that the most significant digit is at the head of the list.
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }

        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            digit += plus;
            if (digit > 9) {
                plus = 1;
                if (digit == 10) {
                    digit = 0;
                } else {
                    digit -= 9;
                }
            } else {
                plus = 0;
            }
            digits[i] = digit;
        }
        int[] result;
        int i = 0;
        if (plus == 1) {
            i = 1;
            result = new int[digits.length + 1];
            result[0] = plus;
        } else {
            result = new int[digits.length];
        }
        for (int j = i; j < digits.length; j++) {
            result[j] = digits[j];
        }
        return result;
    }
}
