package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 7/22/16.
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
public class MaxPathSum {

    //https://leetcode.com/problems/binary-tree-maximum-path-sum/

    int maxValue;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    /**
     * Given a binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child
     * connections. The path does not need to go through the root.
     *
     * For example:
     * Given the below binary tree,
     *
     * 1
     * / \
     * 2   3
     * Return 6.
     */
    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
