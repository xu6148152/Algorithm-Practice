package com.binea.www.leetcodepractice.algorithm.easy;

import com.binea.www.leetcodepractice.algorithm.ListNode;

/**
 * Created by binea on 28/9/2017.
 */

public class RemoveLinkedListElements {

    /**
     * Remove all elements from a linked list of integers that have value val.
     * <p>
     * Example
     * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     * Return: 1 --> 2 --> 3 --> 4 --> 5
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements1ms(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
