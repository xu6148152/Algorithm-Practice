package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 6/30/16.
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
public class N_Queens_II {
    /**
     * Follow up for N-Queens problem.
     *
     * Now, instead outputting board configurations, return the total number of distinct solutions.
     */
    int count = 0;
    public int totalNQueens2ms(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }

    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }

    public int totalNQueens1msWithNoneExtraSpace(int n) {
        dfs(0, n, 0, 0, 0);
        return count;
    }

    private void dfs(int row, int n, int column, int diag, int antiDiag) {
        if (row == n) {
            ++count;
            return;
        }
        for (int i = 0; i < n; ++i) {
            boolean isColSafe = ((1 << i) & column) == 0;
            boolean isDiagSafe = ((1 << (n - 1 + row - i)) & diag) == 0;
            boolean isAntiDiagSafe = ((1 << (row + i)) & antiDiag) == 0;
            if (isColSafe && isDiagSafe && isAntiDiagSafe) {
                dfs(row + 1, n, (1 << i) | column, (1 << (n - 1 + row - i)) | diag, (1 << (row + i)) | antiDiag);
            }
        }
    }
}
