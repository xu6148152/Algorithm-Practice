package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 6/3/16.
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 */
public class ZigZagConversion {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like
     * this:
     * (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */

    //using StringBuilder instead of StringBuffer will reduce runtime to 10ms
    public static String convert14ms(String text, int nRows) {
        char[] c = text.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuilder();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    public static String convert8ms(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int adder = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i += adder) {
            builder.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; ++i) {
            int j = i;
            while (j < s.length()) {
                builder.append(s.charAt(j));
                int next = 2 * numRows - 2 * i - 2 + j;
                if (next < s.length()) {
                    builder.append(s.charAt(next));
                } else {
                    break;
                }
                j += adder;
            }
        }
        for (int i = numRows - 1; i < s.length(); i += adder) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
