package com.example.stack_queue;

import java.util.Stack;

/**
 * Created by binea on 2016/11/9.
 */

public class SortStack {
    private Stack<Integer> orginStack = new Stack<>();

    private Stack<Integer> bufferStack = new Stack<>();

    public void push(Integer value) {
        if(!orginStack.isEmpty()) {
            Integer topValue = orginStack.peek();
            if(topValue < value) {
                topValue = orginStack.pop();
//                bufferStack.push(topValue);
                orginStack.push(value);
                orginStack.push(topValue);
            }
        }else {
            orginStack.push(value);
        }
    }

    public Integer pop() {
        return orginStack.pop();
    }

    public Integer peek() {
        return orginStack.peek();
    }

    public void sort() {
        while(!orginStack.isEmpty()) {
            int tmp = orginStack.pop();
            while(!bufferStack.isEmpty() && bufferStack.peek() > tmp) {
                orginStack.push(bufferStack.pop());
            }
            bufferStack.push(tmp);
        }
    }
}
