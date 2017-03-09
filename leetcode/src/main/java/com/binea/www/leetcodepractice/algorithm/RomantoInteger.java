package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 20/12/2016.
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

public class RomantoInteger {

    /**
     * Given a roman numeral, convert it to an integer.
     *
     * Input is guaranteed to be within the range from 1 to 3999.
     */
    public int roman2int(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int pre = charToInt(s.charAt(0));
        int sum = pre;
        for (int i = 1; i < s.length(); i++) {
            int cur = charToInt(s.charAt(i));
            if (pre < cur) {
                sum -= 2 * pre;
            }
            sum += cur;
            pre = cur;
        }
        return sum;
    }

    public int charToInt(char cha) {
        switch (cha) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
