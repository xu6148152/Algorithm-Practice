package com.example.stack_queue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by binea on 2016/11/9.
 */

public class SetOfStacks {
    private final int DEFAULT_SINGLE_STACK_SIZE = 10;
    ArrayList<Stack<Integer>> stacks = new ArrayList<>();

    private int totalSize = 0;
    public SetOfStacks() {
        Stack<Integer> stack = new Stack<>();
        stack.setSize(DEFAULT_SINGLE_STACK_SIZE);
        stacks.add(stack);
    }

    public void push(int value) {
        Stack<Integer> stack = stacks.get(stacks.size() - 1);
        if(stack.size() == DEFAULT_SINGLE_STACK_SIZE) {
            Stack<Integer> newStack = new Stack<>();
            newStack.setSize(DEFAULT_SINGLE_STACK_SIZE);
            newStack.push(value);
            stacks.add(newStack);
        }else {
            stack.push(value);
        }
        totalSize ++;
    }

    public int pop() throws Exception{
        if(totalSize == 0) {
            throw new Exception("Trying to pop an empty stack");
        }

        Stack<Integer> stack = stacks.get(stacks.size() - 1);
        return stack.pop();
    }

    public int size() {
        return totalSize;
    }

    public int popAt(int stackNums) {
        if(stackNums < 0 || stackNums > stacks.size()) {
            return 0;
        }
        Stack<Integer> stack = stacks.get(stackNums);
        return stack.pop();
    }

}
