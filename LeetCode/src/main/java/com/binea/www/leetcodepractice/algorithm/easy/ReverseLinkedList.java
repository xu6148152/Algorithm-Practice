package com.binea.www.leetcodepractice.algorithm.easy;

import com.binea.www.leetcodepractice.algorithm.ListNode;

/**
 * Created by binea on 29/9/2017.
 */

public class ReverseLinkedList {

    /**
     * Reverse a singly linked list.
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
