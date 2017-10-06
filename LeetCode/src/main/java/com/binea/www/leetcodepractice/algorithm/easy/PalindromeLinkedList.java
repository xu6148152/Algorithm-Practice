package com.binea.www.leetcodepractice.algorithm.easy;

import com.binea.www.leetcodepractice.algorithm.ListNode;

/**
 * Created by binea on 6/10/2017.
 */

public class PalindromeLinkedList {

    /**
     * Given a singly linked list, determine if it is a palindrome.
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        if (head.val == head.next.val && head.next.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode cur = head.next;
        while (cur.next != null) {
            if (slow.val == cur.next.val) {
                if (cur.next.next != null) {
                    return false;
                }
                cur.next = null;
                slow = slow.next;
                cur = slow.next;
                if (cur == null || slow.val == cur.val) {
                    return true;
                }
            } else {
                cur = cur.next;
            }
        }
        return false;
    }
}
