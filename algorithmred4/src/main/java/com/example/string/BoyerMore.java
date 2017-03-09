package com.example.string;

/**
 * Created by binea on 2016/11/7.
 */

public class BoyerMore {
    private final int R = 256;

    public int search(String text, String pattern) {
        int[] right = prepareRight(pattern);

        int m = text.length();
        int n = pattern.length();
        if (n > m) {
            return -1;
        }
        int skip = 0;
        for (int i = 0; i <= m - n; i += skip) {
            skip = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = j - right[text.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                    }
                }
            }
            if (skip == 0) {
                return i;
            }
        }
        return n;
    }

    private int[] prepareRight(String pattern) {
        int[] right = new int[R];
        int length = pattern.length();
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }

        for (int i = 0; i < length; i++) {
            right[pattern.charAt(i)] = i;
        }

        return right;
    }
}
