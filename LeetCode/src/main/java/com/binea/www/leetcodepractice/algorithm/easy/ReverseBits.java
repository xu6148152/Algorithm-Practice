package com.binea.www.leetcodepractice.algorithm.easy;

/**
 * Created by binea on 26/9/2017.
 */

public class ReverseBits {

    /**
     * Reverse bits of a given 32 bits unsigned integer.
     * <p>
     * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
     * <p>
     * Follow up:
     * If this function is called many times, how would you optimize it?
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }

        return result;
    }

    public int reverseBits1ms(int n) {
        int res = 0;
        for (int i = 0; i < 16; i++) {
            int lv = n >> 31 - i & 1;
            int rv = n >> i & 1;

            res |= lv << i;
            res |= rv << 31 - i;
        }

        return res;
    }
}
