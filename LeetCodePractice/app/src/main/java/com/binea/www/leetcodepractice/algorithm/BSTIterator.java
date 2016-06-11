package com.binea.www.leetcodepractice.algorithm;

import java.util.Stack;

/**
 * Created by xubinggui on 6/11/16.
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
public class BSTIterator {

    /**
     * Implement an iterator over a binary search tree (BST). Your iterator will be initialized
     * with the root node of a BST.
     *
     * Calling next() will return the next smallest number in the BST.
     *
     * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is
     * the height of the tree.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<TreeNode> mStack;

    public BSTIterator(TreeNode root) {

        mStack = new Stack<>();
        while (root != null) {
            mStack.push(root);
            if (root.left != null) {
                root = root.left;
            } else {
                break;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !mStack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = mStack.pop();
        TreeNode cur = node;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                mStack.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    break;
                }
            }
        }
        return node.val;
    }

    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
