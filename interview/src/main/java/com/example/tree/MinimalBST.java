package com.example.tree;

/**
 * Created by binea on 2016/11/11.
 */

public class MinimalBST {


    public TreeNode createMinimalBST(int[] array, int start, int end) {
        if (end < start || array == null) {
            return null;
        }

        int mid = array.length / 2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);
        return n;
    }

    public TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }
}
