package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 5/19/16.
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
public class ReverseInteger {
    /**
     * Reverse digits of an integer.
     *
     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     */
    public static int reverse(int x) {
        String value = x + "";
        if (x < 0) {
            value = value.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = value.length() - 1; i >= 0; i--) {
            sb.append(value.charAt(i));
        }
        if (x < 0) {
            value = "-" + sb.toString();
        } else {
            value = sb.toString();
        }
        try {
            x = Integer.valueOf(value);
        } catch (NumberFormatException e) {
            x = 0;
        }
        return x;
    }

    public static int reverse2(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
