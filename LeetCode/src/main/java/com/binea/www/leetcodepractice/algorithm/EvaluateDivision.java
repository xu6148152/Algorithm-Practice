package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 9/29/16.
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

import java.util.HashMap;

public class EvaluateDivision {

    /**
     * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point
     * number). Given some queries, return the answers. If the answer does not exist, return -1.0.
     *
     * Example:
     * Given a / b = 2.0, b / c = 3.0.
     * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
     * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
     *
     * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() ==
     * values.size(), and the values are positive. This represents the equations. Return vector<double>.
     *
     * According to the example above:
     *
     * equations = [ ["a", "b"], ["b", "c"] ],
     * values = [2.0, 3.0],
     * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
     * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
     */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        HashMap<String, Integer> nodes = new HashMap<>();
        int nodeCount = 0;
        for (String[] eq : equations) {

            String src = eq[0];
            String dest = eq[1];

            if (!nodes.containsKey(src)) {
                nodes.put(src, nodeCount++);
            }
            if (!nodes.containsKey(dest)) {
                nodes.put(dest, nodeCount++);
            }
        }

        double[][] map = new double[nodeCount][nodeCount];
        int len = equations.length;
        if (values.length != len) {
            return null;
        }

        for (int i = 0; i < len; i++) {
            String[] eq = equations[i];
            double val = values[i];
            int src = nodes.get(eq[0]);
            int dest = nodes.get(eq[1]);

            map[src][dest] = val;
            map[src][src] = 1.0;
            map[dest][dest] = 1.0;
            map[dest][src] = 1.0 / val;
        }

        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0; j < nodeCount; j++) {
                for (int k = 0; k < nodeCount; k++) {
                    if (map[i][j] == 0 || map[j][k] == 0) {
                        continue;
                    }
                    map[i][k] = map[i][j] * map[j][k];
                }
            }
        }

        double res[] = new double[queries.length];
        len = queries.length;
        for (int i = 0; i < len; i++) {
            String[] eq = queries[i];
            Integer src = nodes.get(eq[0]);
            Integer dest = nodes.get(eq[1]);
            if (src == null || dest == null) {
                res[i] = -1.0;
                continue;
            }
            double val = map[src][dest];
            if (val == 0) {
                res[i] = -1.0;
            } else {
                res[i] = val;
            }
        }
        return res;
    }
}
