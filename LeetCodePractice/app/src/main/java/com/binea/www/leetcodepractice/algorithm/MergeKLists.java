package com.binea.www.leetcodepractice.algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xubinggui on 6/22/16.
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
public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
     * complexity.
     */
    public ListNode mergeKLists13ms(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue =
                new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                    @Override public int compare(ListNode o1, ListNode o2) {
                        if (o1.val < o2.val) {
                            return -1;
                        } else if (o1.val == o2.val) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null) {
                queue.add(node);
            }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode former = null;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                if (former == null) {
                    former = l2;
                } else {
                    former.next = l2;
                }
                if (head == null) {
                    head = former;
                } else {
                    former = former.next;
                }
                l2 = l2.next;
            } else {
                if (former == null) {
                    former = l1;
                } else {
                    former.next = l1;
                }
                if (head == null) {
                    head = former;
                } else {
                    former = former.next;
                }
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            l1 = l2;
        }
        former.next = l1;
        return head;
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }
        if (lists.size() == 2) {
            return mergeTwoLists(lists.get(0), lists.get(1));
        }
        return mergeTwoLists(mergeKLists(lists.subList(0, lists.size() / 2)),
                             mergeKLists(lists.subList(lists.size() / 2, lists.size())));
    }

    public static ListNode mergeKLists5ms(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    public static ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
