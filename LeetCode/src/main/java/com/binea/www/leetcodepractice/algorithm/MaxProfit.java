package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 6/21/16.
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
public class MaxProfit {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     */
    public int maxProfit6ms(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int i : prices) {                              // Assume we only have 0 money at first
            release2 = Math.max(release2,
                                hold2 + i);     // The maximum if we've just sold 2nd stock so far.
            hold2 = Math.max(hold2,
                             release1 - i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1,
                                hold1 + i);     // The maximum if we've just sold 1nd stock so far.
            hold1 = Math.max(hold1,
                             -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    public int maxProfit4ms(int[] prices) {
        // these four variables represent your profit after executing corresponding transaction
        // in the beginning, your profit is 0.
        // when you buy a stock ,the profit will be deducted of the price of stock.
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) {
                firstBuy = -curPrice; // the max profit after you buy first stock
            }
            if (firstSell < firstBuy + curPrice) {
                firstSell = firstBuy + curPrice; // the max profit after you sell it
            }
            if (secondBuy < firstSell - curPrice) {
                secondBuy = firstSell - curPrice; // the max profit after you buy the second stock
            }
            if (secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice; // the max profit after you sell the second stock
            }
        }

        return secondSell; // secondSell will be the max profit after passing the prices
    }
}
