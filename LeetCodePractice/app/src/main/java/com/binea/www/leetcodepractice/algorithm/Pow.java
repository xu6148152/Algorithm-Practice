package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 10/18/16.
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

public class Pow {
    public double myPow(double x, int n) {
        double ans = 1;
        for (long i = Math.abs((long) n); i > 0; i = i >> 1, x *= x)
            if ((i & 1) == 1) {
                ans *= x;
            }
        return n > 0 ? ans : 1 / ans;
    }

    public double myPow23ms(double x, int n) {
        double[] stored = new double[32];
        stored[0] = x;
        for (int i = 1; i < 32; i++)
            stored[i] = stored[i - 1] * stored[i - 1];

        int exponent = n < 0 ? n == Integer.MIN_VALUE ? Integer.MIN_VALUE : -n : n;
        double ans = 1;
        for (int i = 0; i < 32; i++) {
            if ((exponent & (1 << i)) != 0) {
                ans *= stored[i];
            }
        }

        return n > 0 ? ans : 1 / ans;
    }
}
