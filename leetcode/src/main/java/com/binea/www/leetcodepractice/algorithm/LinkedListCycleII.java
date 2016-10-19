package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 8/4/16.
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易 
public class LinkedListCycleII {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * Note: Do not modify the linked list.
     *
     * Follow up:
     * * @param head
     */
    public ListNode detectCycle1ms(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode firstp = head;
        ListNode secondp = head;
        boolean isCycle = false;

        while (firstp != null && secondp != null) {
            firstp = firstp.next;
            if (secondp.next == null) {
                return null;
            }
            secondp = secondp.next.next;
            if (firstp == secondp) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return null;
        }
        firstp = head;
        while (firstp != secondp) {
            firstp = firstp.next;
            secondp = secondp.next;
        }

        return firstp;
    }
}
