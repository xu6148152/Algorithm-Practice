package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 6/9/16.
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
public class ReverseWords {

    /**
     * Given an input string, reverse the string word by word.
     *
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     */
    public static String reverseWords14ms(String str) {
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        while (str.length() > 0) {
            int spaceIndex = str.lastIndexOf(" ");
            if (spaceIndex == -1 || spaceIndex == 0) {
                sb.append(str);
                break;
            }
            sb.append(str.substring(spaceIndex + 1));
            sb.append(" ");
            str = str.substring(0, spaceIndex).trim();
        }

        return sb.toString().trim();
    }

    public String reverseWorlds11ms(String s) {
        String[] parts = s.trim().split("\\s+");
        if (parts.length == 0) {
            return "";
        }
        StringBuilder out = new StringBuilder();
        for (int i = parts.length - 1; i > 0; i--) {
            out.append(parts[i]);
            out.append(" ");
        }
        out.append(parts[0]);
        return out.toString();
    }
}
