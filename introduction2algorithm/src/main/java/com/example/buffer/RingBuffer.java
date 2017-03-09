package com.example.buffer;

//  Created by xubinggui on 16/11/2016.
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

public class RingBuffer {
    private final Object[] buffer;

    private byte start = 0;
    private byte end = 0;

    public RingBuffer(int capacity) {
        buffer = new Object[capacity];
    }

    /**
     * put object to buffer.
     *
     * @throws IllegalStateException if buffer is full
     */
    public void put(Object val) throws IllegalStateException {
        //asset
        assert val != null;

        if (isFull()) {
            throw new IllegalStateException("the buffer is full");
        }

        buffer[end++] = val;
        if (end == buffer.length) {
            end = 0;
        }
    }

    /**
     * check buffer is full
     */
    public boolean isFull() {
        if (end + 1 == start) {
            return true;
        }

        if (end == buffer.length - 1 && start == 0) {
            return true;
        }

        return false;
    }

    /**
     * get object from buffer
     *
     * @throws IllegalStateException if buffer is empty
     */
    public Object get() throws IllegalStateException {
        if (start != end) {
            Object obj = buffer[start++];
            if (start == buffer.length) {
                start = 0;
            }
            return obj;
        } else {
            throw new IllegalStateException("the buffer is empty");
        }
    }
}
