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
        if (source == null || source.length < length) {
            return null;
        }
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

    public String compressString(String source) {
        if (source == null) {
            return null;
        }

        if (getCompressCount(source) >= source.length()) {
            return source;
        }

        final char[] chars = source.toCharArray();
        int nums = 1;
        Character letter = null;
        StringBuilder sb = new StringBuilder();
        for (Character character : chars) {
            if (character.equals(letter)) {
                nums++;
            } else {
                if (letter != null) {
                    sb.append(letter);
                    sb.append(nums);
                }
                letter = character;
                nums = 1;
            }
        }
        sb.append(letter);
        sb.append(nums > 1 ? nums : "");

        return sb.toString();
    }

    private int getCompressCount(String source) {
        final char[] chars = source.toCharArray();
        char letter = ' ';
        int size = 0;
        for (Character character : chars) {
            if (character.equals(letter)) {
            } else {
                size += 2;
                letter = character;
            }
        }
        size += 2;
        return size;
    }

    public void rotate(int[][] matrix, int n) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                //left to top
                matrix[first][i] = matrix[last - offset][first];

                //bottom to right
                matrix[last - offset][first] = matrix[last][last - offset];

                //right to bottom
                matrix[last][last - offset] = matrix[i][last];

                //top to right
                matrix[i][last] = top;
            }
        }
    }

    public void setZeros(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[i] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        String s1s2 = s1 + s1;
        return isSubstring(s1s2, s2);
    }

    private boolean isSubstring(String s1, String s2) {
        return false;
    }

    private void preKmp(char[] x, int m, int kmpNext[]) {
        int i, j;
        i = 0;
        j = kmpNext[0] = -1;
        while (i < m) {
            while (j > -1 && x[i] != x[j]) {
                j = kmpNext[j];
            }
            i++;
            j++;
            if (x[i] == x[j]) {
                kmpNext[i] = kmpNext[j];
            } else {
                kmpNext[i] = j;
            }
        }
    }

    /**
     *
     * @param x pattern
     * @param m
     * @param y source
     * @param n
     */
    private void KMP(char[] x, int m, char[] y, int n) {
        int i, j;
        int[] kmpNext = new int[x.length];

        //preprocessing
        preKmp(x, m, kmpNext);

        //searching
        i = j = 0;
        while (j < n) {
            while (i > -1 && x[i] != y[i]) {
                i = kmpNext[j];
            }
            i++;
            j++;
            if (i >= m) {
                i = kmpNext[i];
            }
        }
    }
}
