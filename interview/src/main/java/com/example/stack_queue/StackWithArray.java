package com.example.stack_queue;

/**
 * Created by binea on 2016/11/8.
 */

public class StackWithArray {

    class StackData {
        public int start;
        public int pointer;
        public int size;
        public int capacity;

        public StackData(int _start, int _capacity) {
            start = _start;
            capacity = _capacity;
        }

        public boolean isWithinStack(int index, int totalSize) {
            if (start <= index && index < start + capacity) {
                return true;
            } else if (start + capacity > totalSize && index < (start + capacity) % totalSize) {
                return true;
            }
            return false;
        }
    }

    private final int NUMBER_OF_STACKS = 3;
    private final int DEFAULT_SIZE = 4;
    private final int TOTAL_SIZE = NUMBER_OF_STACKS * DEFAULT_SIZE;
    private final StackData[] stacks = {new StackData(0, DEFAULT_SIZE), new StackData(DEFAULT_SIZE, DEFAULT_SIZE), new StackData(DEFAULT_SIZE * 2, DEFAULT_SIZE)};

    private final int[] buffer = new int[TOTAL_SIZE];

    public int numberOfElements() {
        return stacks[0].size + stacks[1].size + stacks[2].size;
    }

    public int nextElement(int index) {
        if(index + 1 == TOTAL_SIZE) {
            return 0;
        }
        return index + 1;
    }

    public int previousElement(int index) {
        if(index == 0) {
            return TOTAL_SIZE - 1;
        }
        return index - 1;
    }

    public void shift(int stackNum) {
        if(stackNum < 0 || stackNum > stacks.length) {
            return;
        }
        StackData stackData = stacks[stackNum];
        if(stackData.size >= stackData.capacity) {
            int nextStack = (stackNum + 1) % NUMBER_OF_STACKS;
            shift(nextStack);
            stackData.capacity++;
        }

        for (int i = (stackData.start + stackData.capacity - 1) % TOTAL_SIZE; stackData.isWithinStack(i, TOTAL_SIZE); i = previousElement(i)) {
            buffer[i] = buffer[previousElement(i)];
        }

        buffer[stackData.start] = 0;
        stackData.start = nextElement(stackData.start);
        stackData.pointer = nextElement(stackData.pointer);
        stackData.capacity--;
    }

    public void expand(int stackNum) {
        shift((stackNum + 1) % NUMBER_OF_STACKS);
        stacks[stackNum].capacity++;
    }

    public void push(int stackNum, int value) throws Exception{
        StackData stackData = stacks[stackNum % NUMBER_OF_STACKS];
        if(stackData.size >= stackData.capacity) {
            if(numberOfElements() >= TOTAL_SIZE) {
                throw new Exception("Out of space");
            }else {
                expand(stackNum);
            }
        }

        stackData.size++;
        stackData.pointer = nextElement(stackData.pointer);
        buffer[stackData.pointer] = value;
    }

    public int pop(int stackNum) throws Exception {
        StackData stackDatas = stacks[stackNum % NUMBER_OF_STACKS];
        if(stackDatas.size == 0) {
            throw new Exception("Trying to pop an empty stack");
        }
        int value = buffer[stackDatas.pointer];
        buffer[stackDatas.pointer] = 0;
        stackDatas.pointer = previousElement(stackNum);
        stackDatas.size--;
        return value;
    }

    public int peek(int stackNum) {
        StackData stackData = stacks[stackNum % TOTAL_SIZE];
        return buffer[stackData.pointer];
    }

    public boolean isEmpty(int stackNum) {
        return stacks[stackNum % TOTAL_SIZE].size == 0;
    }

}
