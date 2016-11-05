package com.example.string;

//  Created by xubinggui on 05/11/2016.
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

import java.util.HashSet;
import java.util.Set;

public class StringSubject {
    public boolean isAllCharacterDifferent(String source, boolean usingDataStruct) {
        final char[] chars = source.toCharArray();
        if (usingDataStruct) {
            Set<Character> characterSet = new HashSet<>();
            for (Character character : chars) {
                characterSet.add(character);
            }

            return characterSet.size() == source.length();
        }

        int[] charContainer = new int[26];
        for (Character character : chars) {
            charContainer[character - 'a']++;
        }

        for (int i = 0; i < charContainer.length; i++) {
            if (charContainer[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
