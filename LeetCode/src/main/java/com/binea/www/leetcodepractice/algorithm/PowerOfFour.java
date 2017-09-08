package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 8/10/16.
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
public class PowerOfFour {
    /**
     * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
     *
     * Example:
     * Given num = 16, return true. Given num = 5, return false.
     *
     * Follow up: Could you solve it without loops/recursion?
     */
    public boolean isPowerOfFour(int num) {
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
