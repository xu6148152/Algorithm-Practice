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
}
