package com.example.stack_queue;

import java.util.Stack;

/**
 * Created by binea on 2016/11/9.
 */

public class MyQueue<T> {
    private Stack<T> newestStack;
    private Stack<T> oldestStack;

    public MyQueue() {
        newestStack = new Stack<>();
        oldestStack = new Stack<>();
    }

    public void add(T t) {
        newestStack.add(t);
    }

    public T peek() {
        shiftStacks();
        return oldestStack.peek();
    }

    public T remove() {
        shiftStacks();
        return oldestStack.pop();
    }

    private void shiftStacks() {
        if(oldestStack.isEmpty()) {
            while (!newestStack.isEmpty()) {
                oldestStack.add(newestStack.pop());
            }
        }
    }

    public int size() {
        return newestStack.size() + oldestStack.size();
    }
}
