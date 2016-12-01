package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 01/12/2016.
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

public class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return null;
        }

        String res = strs.length == 0 ? "" : strs[0];

        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        return res;
    }
}
