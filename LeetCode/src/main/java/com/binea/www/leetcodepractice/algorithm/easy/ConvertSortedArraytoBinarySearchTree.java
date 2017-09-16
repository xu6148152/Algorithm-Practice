package com.binea.www.leetcodepractice.algorithm.easy;

import com.binea.www.leetcodepractice.algorithm.TreeNode;

/**
 * Created by binea on 16/9/2017.
 */

public class ConvertSortedArraytoBinarySearchTree {

    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = help(nums, low, mid - 1);
        treeNode.right = help(nums, mid + 1, high);
        return treeNode;
    }
}
