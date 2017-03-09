package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xubinggui on 6/28/16.
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
public class DifferentWaysToAddParentheses {

    /**
     *
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }
        List<String> ops = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int j = i;
            while (j < input.length() && Character.isDigit(input.charAt(j))) {
                j++;
            }
            ops.add(input.substring(i, j));
            if (j != input.length()) {
                ops.add(input.substring(j, j + 1));
            }
            i = j;
        }
        int N = (ops.size() + 1) / 2; //num of integers
        ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
        for (int d = 0; d < N; d++) {
            if (d == 0) {
                for (int i = 0; i < N; i++) {
                    dp[i][i] = new ArrayList<>();
                    dp[i][i].add(Integer.valueOf(ops.get(i * 2)));
                }
                continue;
            }
            for (int i = 0; i < N - d; i++) {
                dp[i][i + d] = new ArrayList<>();
                for (int j = i; j < i + d; j++) {
                    ArrayList<Integer> left = dp[i][j], right = dp[j + 1][i + d];
                    String operator = ops.get(j * 2 + 1);
                    for (int leftNum : left)
                        for (int rightNum : right) {
                            if (operator.equals("+")) {
                                dp[i][i + d].add(leftNum + rightNum);
                            } else if (operator.equals("-")) {
                                dp[i][i + d].add(leftNum - rightNum);
                            } else {
                                dp[i][i + d].add(leftNum * rightNum);
                            }
                        }
                }
            }
        }
        return dp[0][N - 1];
    }
}
