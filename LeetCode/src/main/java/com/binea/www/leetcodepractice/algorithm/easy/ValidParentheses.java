package com.binea.www.leetcodepractice.algorithm.easy;

import java.util.Stack;

/**
 * Created by binea on 9/9/2017.
 */

public class ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isLeftSymbol(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                Character symbol = stack.pop();
                if (isLeftSymbol(symbol)) {
                    if (c == ')' && symbol != '(') {
                        return false;
                    }
                    if (c == ']' && symbol != '[') {
                        return false;
                    }
                    if (c == '}' && symbol != '{') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public boolean isLeftSymbol(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}
