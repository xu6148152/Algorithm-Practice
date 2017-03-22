package com.binea.www.leetcodepractice.algorithm;
// Created by binea on 3/22/17.

public class PopulatingNextRightPointers {
    class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;

                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }
}
