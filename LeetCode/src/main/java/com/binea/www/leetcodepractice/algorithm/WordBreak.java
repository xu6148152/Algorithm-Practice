package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 12/01/2017.
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

import java.util.List;

public class WordBreak {
    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a
     * space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
     *
     * For example, given
     * s = "leetcode",
     * dict = ["leet", "code"].
     *
     * Return true because "leetcode" can be segmented as "leet code".
     *
     * UPDATE (2017/1/4):
     * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the
     * latest
     * changes.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0 || s == null || s.length() == 0) {
            return false;
        }
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
