package com.binea.www.leetcodepractice.algorithm;

import java.util.Stack;

//  Created by xubinggui on 8/25/16.
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
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        int[] ls = new int[tokens.length/2+1];
        int index = 0;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    ls[index - 2] = ls[index - 2] + ls[index - 1];
                    index--;
                    break;
                case "-":
                    ls[index - 2] = ls[index - 2] - ls[index - 1];
                    index--;
                    break;
                case "*":
                    ls[index - 2] = ls[index - 2] * ls[index - 1];
                    index--;
                    break;
                case "/":
                    ls[index - 2] = ls[index - 2] / ls[index - 1];
                    index--;
                    break;
                default:
                    ls[index++] = Integer.parseInt(token);
                    break;
            }
        }
        return ls[0];
    }
}
