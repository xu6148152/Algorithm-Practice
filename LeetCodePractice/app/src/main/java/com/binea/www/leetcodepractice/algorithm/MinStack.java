package com.binea.www.leetcodepractice.algorithm;

/**
 * Created by xubinggui on 6/19/16.
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

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant
 * time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    public Elem top;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (top == null) {
            top = new Elem(x, x);
        } else {
            Elem e = new Elem(x, Math.min(x, top.min));
            e.next = top;
            top = e;
        }
    }

    public void pop() {
        if (top == null) {
            return;
        }
        Elem temp = top.next;
        top.next = null;
        top = temp;
    }

    public int top() {
        if (top == null) {
            return -1;
        }
        return top.value;
    }

    public int getMin() {
        if (top == null) {
            return -1;
        }
        return top.min;
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}

class Elem {
    public int value;
    public int min;
    public Elem next;

    public Elem(int value, int min) {
        this.value = value;
        this.min = min;
    }
}
