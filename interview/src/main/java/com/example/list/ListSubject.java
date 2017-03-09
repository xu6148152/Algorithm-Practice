package com.example.list;

//  Created by xubinggui on 06/11/2016.
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

import java.util.HashMap;

public class ListSubject {

    class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }

        void addToTail(int d) {
            Node node = new Node(d);
            Node current = this;
            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }
    }

    public void removeDuplicateNode(Node root) {
        if (root == null) {
            return;
        }
        HashMap<Integer, Node> nodeHashMap = new HashMap<>();
        Node current = root;
        Node preNode = root;
        while (current != null) {
            if (!nodeHashMap.containsKey(current.data)) {
                nodeHashMap.put(root.data, current);
                preNode = current;
            } else {
                preNode.next = current.next;
            }
            current = current.next;
        }
    }

    public boolean deleteNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }

        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }

    public Node splitList(Node node, int x) {
        if (node == null) {
            return null;
        }

        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while (node != null) {
            Node next = node.next;
            node.next = null;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }

            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    class NodeIndex {
        public int index;

        public NodeIndex(int index, Node node) {
            this.index = index;
        }
    }

    public Node findLastKNode(Node root, int k, NodeIndex nodeIndex) {
        if (root == null) {
            return null;
        }

        Node node = findLastKNode(root.next, k, nodeIndex);
        nodeIndex.index++;
        if (nodeIndex.index == k) {
            return root;
        }
        return node;
    }

    public Node findLstKNode(Node root, int k) {
        if (root == null) {
            return null;
        }

        Node p1 = root;
        Node p2 = root;
        for (int i = 0; i < k - 1; i++) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p1;
    }

    public Node sumNode(Node node1, Node node2, int carry) {
        if (node1 == null && node2 == null && carry == 0) {
            return null;
        }

        Node result = new Node(0);

        int value = carry;

        if (node1 != null) {
            value += node1.data;
        }

        if (node2 != null) {
            value += node2.data;
        }

        result.data = value % 10;

        result.next = sumNode(node1 == null ? null : node1.next, node2 == null ? null : node2.next, value > 9 ? 1 : 0);

        return result;
    }

    public Node findBeginning(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    class Result {
        Node node;
        boolean result;

        public Result(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }
    public Result isPalindromeRecurse(Node head, int length) {
        if(head == null || length == 0) {
            return new Result(null, true);
        }

        if(length == 1) {
            return new Result(head.next, true);
        }

        if(length == 2) {
            return new Result(head.next.next, head.data == head.next.data);
        }

        Result result = isPalindromeRecurse(head.next, length -1);
        if(!result.result || result.node == null) {
            return result;
        }
        result.result = head.data == result.node.data;
        result.node = result.node.next;
        return result;
    }
}
