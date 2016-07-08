package com.binea.www.leetcodepractice.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xubinggui on 7/8/16.
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 */
public class SuperPow {

    /**
     * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely
     * large positive integer given in the form of an array.
     *
     * Example1:
     *
     * a = 2
     * b = [3]
     *
     * Result: 8
     * Example2:
     *
     * a = 2
     * b = [1,0]
     *
     * Result: 1024
     */
    int DIV = 1337;

    List<Integer> findLoop(int a) {
        List<Integer> index = new ArrayList<>();
        boolean[] set = new boolean[DIV];
        int rem = a % DIV;
        while (!set[rem]) {
            set[rem] = true;
            index.add(rem);
            rem = (rem * a) % DIV;
        }
        return index;
    }

    int modBy(int[] b, int m) {
        int rem = 0;
        for (int i = 0; i < b.length; i++) {
            rem = (rem * 10 + b[i]) % m;
        }
        return rem;
    }

    public int superPow(int a, int[] b) {
        if (a == 0 || a == DIV || b == null || b.length == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        if (a > DIV) {
            return superPow(a % DIV, b);
        }
        List<Integer> index = findLoop(a);
        int loopsize = index.size();
        int rem = modBy(b, loopsize);
        rem = rem == 0 ? loopsize : rem;
        return index.get(rem - 1);
    }
}
