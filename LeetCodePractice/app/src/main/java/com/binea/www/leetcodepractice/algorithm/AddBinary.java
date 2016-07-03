package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 7/3/16.
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
public class AddBinary {

    /**
     * Given two binary strings, return their sum (also a binary string).
     *
     * For example,
     * a = "11"
     * b = "1"
     * Return "100".
     */
    public static String addBinary3ms(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;

        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();

        char[] reschar = new char[Math.max(achar.length, bchar.length) + 2];
        int k = 0;

        while (true) {
            if (i < 0 && j < 0 && c == 0) {
                break;
            }

            int aint = 0;
            int bint = 0;

            if (i >= 0) {
                aint = achar[i] - '0';
            }
            if (j >= 0) {
                bint = bchar[j] - '0';
            }
            if (aint + bint + c > 1) {
                reschar[k] = (char) ('0' + aint + bint + c - 2);
                c = 1;
            } else {
                reschar[k] = (char) ('0' + aint + bint + c);
                c = 0;
            }
            k++;
            i--;
            j--;
        }
        return new StringBuffer(new String(reschar, 0, k)).reverse().toString();
    }
}
