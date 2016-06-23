package com.binea.www.leetcodepractice.algorithm;

import java.util.Stack;

/**
 * Created by xubinggui on 6/23/16.
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
public class LongestValidParentheses {

    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest
     * valid (well-formed) parentheses substring.
     *
     * For "(()", the longest valid parentheses substring is "()", which has length = 2.
     *
     * Another example is ")()())", where the longest valid parentheses substring is "()()", which
     * has length = 4.
     */
    public int longestValidParentheses11ms(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                stack.push(j);
            } else {
                if (stack.isEmpty()) {
                    left = j;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, j - left);
                    } else {
                        max = Math.max(max, j - stack.peek());
                    }
                }
            }
        }
        return max;
    }

    int longestValidParentheses6ms(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int curMax = 0;
        int[] longest = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'
                    && i - longest[i - 1] - 1 >= 0
                    && s.charAt(i - longest[i - 1] - 1) == '(') {
                longest[i] =
                        longest[i - 1] + 2 + ((i - longest[i - 1] - 2 >= 0) ? longest[i - longest[i
                                - 1] - 2] : 0);
                curMax = Math.max(longest[i], curMax);
            }
        }
        return curMax;
    }
}
