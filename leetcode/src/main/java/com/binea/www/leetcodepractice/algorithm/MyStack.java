package com.binea.www.leetcodepractice.algorithm;

//  Created by xubinggui on 23/11/2016.
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

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    // Push element x onto stack.
    Queue<Integer> q = new LinkedList<>();
    int top = Integer.MIN_VALUE;

    public void push(int x) {
        q.offer(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            if (i == size - 2) {
                top = q.peek();
            }
            q.offer(q.poll());
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.size() == 0;
    }
}
