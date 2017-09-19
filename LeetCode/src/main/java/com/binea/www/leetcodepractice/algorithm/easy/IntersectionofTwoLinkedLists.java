package com.binea.www.leetcodepractice.algorithm.easy;

import com.binea.www.leetcodepractice.algorithm.ListNode;

/**
 * Created by binea on 19/9/2017.
 */

public class IntersectionofTwoLinkedLists {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * <p>
     * <p>
     * For example, the following two linked lists:
     * <p>
     * A:          a1 → a2
     * ↘
     * c1 → c2 → c3
     * ↗
     * B:     b1 → b2 → b3
     * begin to intersect at node c1.
     * <p>
     * <p>
     * Notes:
     * <p>
     * If the two linked lists have no intersection at all, return null.
     * The linked lists must retain their original structure after the function returns.
     * You may assume there are no cycles anywhere in the entire linked structure.
     * Your code should preferably run in O(n) time and use only O(1) memory.
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}
