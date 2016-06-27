package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 6/27/16.
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
public class HIndex {

    /**
     * Given an array of citations (each citation is a non-negative integer) of a researcher, write
     * a function to compute the researcher's h-index.
     *
     * According to the definition of h-index on Wikipedia: "A scientist has index h if h of
     * his/her
     * N papers have at least h citations each, and the other N − h papers have no more than h
     * citations each."
     *
     * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in
     * total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the
     * researcher has 3 papers with at least 3 citations each and the remaining two with no more
     * than 3 citations each, his h-index is 3.
     *
     * Note: If there are several possible values for h, the maximum one is taken as the h-index.
     */
    public int hIndex1ms(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }

        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                array2[length] += 1;
            } else {
                array2[citations[i]] += 1;
            }
        }
        int t = 0;
        int result = 0;

        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }
}
