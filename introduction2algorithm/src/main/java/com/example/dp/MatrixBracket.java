package com.example.dp;

/**
 * Created by binea on 2016/10/19.
 */

public class MatrixBracket {
    public void getOptimal(int n, int[] array) {
        int[][] m = new int[n][n];
        //①将对角线上的值先赋值为0
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        int l = 0; //l为矩阵链的长度

        //m[i][j]的第一个参数
        int i = 0;

        //m[i][j]的第二个参数
        int j = 0;

        int[] p = new int[n];
        int[][] s = new int[n][n];

        int tmp = 0;

        //②以长度L为划分，L从2开始到n
        for (l = 2; l <= n; l++) {

            //循环第一个参数，因为l的长度至少为2，所以i和j在这个循环里面肯定不相等
            for (i = 1; i <= n - l + 1; i++) {
                //因为j-i+1=l，所以j=l+i-1
                j = i + l - 1;

                //给m[i][j]赋初值，这里要寻找m[i][j]的最小值，本来应当给m[i][j]赋值一个正无穷，但是这里直接赋一个i=j时候的特值也可以
                m[i][j] = m[i][i] + m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i;

                //对于每个特定的i和j的组合，遍历此时所有的合适k值，k大于等于i小于j
                for (int k = i + 1; k < j; k++) { //这里k不能等于j，因为后面要m[k+1][j]，不然k+1就比j大了

                    tmp = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (tmp < m[i][j]) {
                        m[i][j] = tmp;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
}
