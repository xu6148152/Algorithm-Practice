package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 10/13/16.
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

public class CountPrimes {
    /**
     * Count the number of prime numbers less than a non-negative number, n.
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        int c = 1;

        boolean isNotPrime[] = new boolean[n + 1];

        for (int i = 3; i * i <= n; i = i + 2) {

            if (isNotPrime[i]) {

                continue;
            }

            for (int j = i * i; j <= n; j = j + 2 * i) {
                isNotPrime[j] = true;
            }
        }

        for (int i = 3; i < n; i = i + 2) {

            if (!isNotPrime[i]) {
                c++;
            }
        }
        return c;
    }
}
