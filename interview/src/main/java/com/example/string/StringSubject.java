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
    /**
     * own
     */
    public boolean isAllCharacterDifferent(String source, boolean usingDataStruct) {
        if (source == null) {
            return true;
        }
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

    public boolean isUniqueChars(String source) {
        if (source == null || source.length() > 256) {
            return false;
        }

        int checker = 0;
        final char[] chars = source.toCharArray();
        for (Character character : chars) {
            if ((checker & (1 << character)) > 0) {
                return false;
            }
            checker |= (1 << character);
        }
        return true;
    }

    public String reverseString(String source) {
        if (source == null) {
            return null;
        }

        final char[] chars = source.toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return String.valueOf(chars);
    }

    public boolean pretumation(String t, String s) {
        if (t == null || s == null || t.length() != s.length()) {
            return false;
        }

        int[] letters = new int[256];

        final char[] tChars = t.toCharArray();
        for (Character character : tChars) {
            letters[character]++;
        }

        final char[] sChars = s.toCharArray();
        for (Character character : sChars) {
            if (--letters[character] < 0) {
                return false;
            }
        }

        return true;
    }

    public String replaceSpaces(char[] source, int length) {
        int spaces = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (source[i] == ' ') {
                spaces++;
            }
        }

        int newLength = length + spaces * 3;

        source[newLength] = '\0';
        for (int i = length - 1; i >= 0; i--) {
            if (source[i] == ' ') {
                source[newLength - 1] = '0';
                source[newLength - 2] = '2';
                source[newLength - 3] = '%';
                newLength -= 3;
            } else {
                source[newLength - 1] = source[i];
                newLength--;
            }
        }
        for (int i = 0; i < newLength; i++) {
            source[i] = ' ';
        }
        return String.valueOf(source);
    }
}
