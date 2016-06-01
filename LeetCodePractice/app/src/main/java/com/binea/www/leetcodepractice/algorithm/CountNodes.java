package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 6/1/16.
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
public class CountNodes {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /**
     * Given a complete binary tree, count the number of nodes.
     *
     * Definition of a complete binary tree from Wikipedia:
     * In a complete binary tree every level, except possibly the last,
     * is completely filled, and all nodes in the last level are as far left as possible.
     * It can have between 1 and 2h nodes inclusive at the last level h.
     *
     * @return
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int countNodes(TreeNode root) {
        int height = height(root);
        return height < 0 ? 0
                : height(root.right) == height - 1 ? (1 << height) + countNodes(root.right)
                        : (1 << height - 1) + countNodes(root.left);
    }

    private static int height(TreeNode root) {
        return root == null ? -1 : height(root.left) + 1;
    }

    public int countNodes70ms(TreeNode root) {
        int nodes = 0, h = height(root);
        while (root != null) {
            if (height(root.right) == h - 1) {
                nodes += 1 << h;
                root = root.right;
            } else {
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }

    public int countNodes84ms(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null) {
            return (1 << height) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes69ms(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }
        int height = 0;
        int nodesSum = 0;
        TreeNode curr = root;
        while (curr.left != null) {
            nodesSum += (1 << height);
            height++;
            curr = curr.left;
        }
        return nodesSum + countLastLevel(root, height);
    }

    private int countLastLevel(TreeNode root, int height) {
        if (height == 1) {
            if (root.right != null) {
                return 2;
            } else if (root.left != null) {
                return 1;
            } else {
                return 0;
            }
        }
        TreeNode midNode = root.left;
        int currHeight = 1;
        while (currHeight < height) {
            currHeight++;
            midNode = midNode.right;
        }
        if (midNode == null) {
            return countLastLevel(root.left, height - 1);
        } else {
            return (1 << (height - 1)) + countLastLevel(root.right, height - 1);
        }
    }
}
