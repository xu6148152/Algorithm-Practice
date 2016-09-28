package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 9/28/16.
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

public class SumNumbers {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
     *
     * An example is the root-to-leaf path 1->2->3 which represents the number 123.
     *
     * Find the total sum of all root-to-leaf numbers.
     *
     * For example,
     *
     * 1
     * / \
     * 2   3
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     *
     * Return the sum = 12 + 13 = 25.
     */
    int ans = 0;
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumUp(root);
        return ans;
    }

    private void sumUp(TreeNode t) {
        if (t == null) {
            return;
        }
        sum = sum * 10 + t.val;
        if (t.left == null && t.right == null) {
            ans += sum;
            sum = sum / 10;
            return;
        }
        sumUp(t.left);
        sumUp(t.right);
        sum = sum / 10;
    }
}
