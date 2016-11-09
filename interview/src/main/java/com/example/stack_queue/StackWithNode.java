package com.example.stack_queue;

/**
 * Created by binea on 2016/11/8.
 */

public class StackWithNode {
    public class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node top;

    private Node min;

    private Node root;

    private int capacity = 0;

    public void push(Node node) {
        if(node == null) {
            return;
        }


        if(root != null) {
            top.next = node;
        }else {
            root = top = node;
        }

        if(node.val <= top.val) {
            min = node;
        }

        top = node;

        capacity++;
    }

    public Node pop() {
        Node node = root;
        Node topNode = new Node(top.val);
        while(node != null && node.next != top) {
            node = node.next;
        }
        if(node != null) {
            top = node;
            node.next = null;
        }
        return topNode;
    }

    public Node min() {
        return min;
    }
}
