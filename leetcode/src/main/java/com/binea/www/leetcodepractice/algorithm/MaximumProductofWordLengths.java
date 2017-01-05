package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 05/01/2017.
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

public class MaximumProductofWordLengths {

    /**
     * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You
     * may assume that each word will contain only lower case letters. If no such two words exist, return 0.
     *
     * Example 1:
     * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
     * Return 16
     * The two words can be "abcw", "xtfn".
     *
     * Example 2:
     * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
     * Return 4
     * The two words can be "ab", "cd".
     *
     * Example 3:
     * Given ["a", "aa", "aaa", "aaaa"]
     * Return 0
     * No such pair of words.
     */
    public static int maxProduct(String[] words) {
        if (words == null || words.length == 0 || words.length == 1) {
            return 0;
        }

        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmpLength = words[i].length() * words[j].length();
                if ((value[i] & value[j]) == 0 && tmpLength > maxProduct) {
                    maxProduct = tmpLength;
                }
            }
        }
        return maxProduct;
    }
}
