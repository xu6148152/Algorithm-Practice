package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 5/12/16.
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
public class BestTimeToBuyAndSellStockII {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete as many transactions as
     * you like (ie, buy one and sell one share of the stock multiple times). However, you may
     * not engage in multiple transactions at the same time (ie, you must sell the stock before
     * you buy again).
     * greedy
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int total = 0;
        for(int i = 0; i<prices.length - 1; i++) {
            if(prices[i+1] > prices[i]) {
                total += prices[i+1] - prices[i];
            }
        }
        return total;
    }
}
