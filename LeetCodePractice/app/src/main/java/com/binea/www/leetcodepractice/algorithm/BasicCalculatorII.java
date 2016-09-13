package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 9/13/16.
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易 
public class BasicCalculatorII {

    /**
     * Implement a basic calculator to evaluate a simple expression string.
     *
     * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward
     * zero.
     *
     * You may assume that the given expression is always valid.
     *
     * Some examples:
     * "3+2*2" = 7
     * " 3/2 " = 1
     * " 3+5 / 2 " = 5
     * Note: Do not use the eval built-in library function.
     */
    public int calculate(String s) {
        int ans = 0, num = 0, product = 1, op = 1; // op 1: +; -1: -; 2: *; 3: /
        for (char c : s.toCharArray()) {
            switch (c) {
                case ' ':
                    break;
                case '+':
                case '-':
                    ans += op == 2 ? product * num : op == 3 ? product / num : op * num;
                    op = c == '+' ? 1 : -1;
                    num = 0;
                    break;
                case '*':
                case '/':
                    product = op == 2 ? product * num : op == 3 ? product / num : op * num;
                    op = c == '*' ? 2 : 3;
                    num = 0;
                    break;
                default:
                    num = num * 10 + c - '0';
                    break;
            }
        }
        ans += op == 2 ? product * num : op == 3 ? product / num : op * num;
        return ans;
    }
}
