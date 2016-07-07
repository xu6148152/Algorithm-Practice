package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 7/7/16.
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
public class InsertionSortList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList43ms(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while (cur != null) {
            next = cur.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    public ListNode insertionSortList10ms(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sortedHead = head, sortedTail = head;
        head = head.next;
        sortedHead.next = null;

        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;

            // new val is less than the head, just insert in the front
            if (temp.val <= sortedHead.val) {
                temp.next = sortedHead;
                sortedTail = sortedHead.next == null ? sortedHead : sortedTail;
                sortedHead = temp;
            }
            // new val is greater than the tail, just insert at the back
            else if (temp.val >= sortedTail.val) {
                sortedTail.next = temp;
                sortedTail = sortedTail.next;
            }
            // new val is somewhere in the middle, we will have to find its proper
            // location.
            else {
                ListNode current = sortedHead;
                while (current.next != null && current.next.val < temp.val) {
                    current = current.next;
                }

                temp.next = current.next;
                current.next = temp;
            }
        }

        return sortedHead;
    }
}
