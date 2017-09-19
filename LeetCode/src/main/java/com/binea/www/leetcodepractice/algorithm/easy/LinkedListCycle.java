package com.binea.www.leetcodepractice.algorithm.easy;

import com.binea.www.leetcodepractice.algorithm.ListNode;

/**
 * Created by binea on 19/9/2017.
 */

public class LinkedListCycle {

    /**
     * Given a linked list, determine if it has a cycle in it.
     * <p>
     * Follow up:
     * Can you solve it without using extra space?
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (slowNode != fastNode) {
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return true;
    }
}
