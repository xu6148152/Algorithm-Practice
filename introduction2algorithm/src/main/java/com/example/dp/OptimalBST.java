package com.example.dp;

/**
 * Created by binea on 2016/10/22.
 */

public class OptimalBST {

    double p[] = {-1,0.15,0.1,0.05,0.1,0.2};
    double q[] = {0.05,0.1,0.05,0.05,0.05,0.1};

    public void getOptimalBST(int n){
        double[][] w = new double[n + 1][n + 1];

        double[][] e = new double[n + 1][n + 1];

        int[][] root = new int[n + 1][n + 1];

        for(int i = 1; i < n; i++) {
            w[i][i -1] = q[i - 1];
            e[i][i - 1] = q[i - 1];
        }

        for(int l = 1; l <= n ; l++) {
            for(int i = l; i < n - l + 1;) {
                int j = i + l - 1;
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[i] + q[j];
                for(int r = i; r <= j; r++) {
                    double t = e[i][r -1] + e[r + 1][j] + w[i][j];
                    if(t < e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }
        }
    }

    void printRoot(double[][] root, int n) {
        System.out.print("各子树的根：");
        for (int i = 1;i <= n;++i)
        {
            for (int j = 1;j <= n;++j)
            {
                System.out.print(root[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
