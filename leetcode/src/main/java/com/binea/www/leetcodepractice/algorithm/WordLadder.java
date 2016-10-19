package com.binea.www.leetcodepractice.algorithm;

import java.util.HashSet;
import java.util.Set;

//  Created by xubinggui on 8/19/16.
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
public class WordLadder {
    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to
     * endWord, such that:
     *
     * Only one letter can be changed at a time
     * Each intermediate word must exist in the word list
     * For example,
     *
     * Given:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     *
     * Note:
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}
