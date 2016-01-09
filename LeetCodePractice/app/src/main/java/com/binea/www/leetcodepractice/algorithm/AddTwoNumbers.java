package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 1/9/16.
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum = 0;
            ListNode sentinel = new ListNode(0);
            ListNode d = sentinel;
            while(l1 != null || l2 != null) {
                sum /= 10;
                if(l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if(l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                d.next = new ListNode(sum % 10);
                d = d.next;
            }
            if (sum / 10 == 1) {
                d.next = new ListNode(1);
            }
            return sentinel.next;
        }
    }
}
