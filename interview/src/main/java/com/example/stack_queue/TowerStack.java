package com.example.stack_queue;

import java.util.Stack;

/**
 * Created by binea on 2016/11/9.
 */

public class TowerStack {

    public class Tower {
        private Stack<Integer> disks;
        private int index;
        public Tower(int i) {
            disks = new Stack<>();
            index = i;
        }

        public int index() {
            return index;
        }

        public void add(int d) throws Exception{
            if(!disks.isEmpty() && disks.peek() < d) {
                throw new Exception("Can't place greater value at top");
            }
            disks.push(d);
        }

        public void moveTopTo(Tower tower) {
            Integer top = disks.pop();
            try {
                tower.add(top);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            System.out.println("Move disk " + top + " from " + index() + " to " + tower.index());
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if(n > 0) {
                //move n-1 disks to buffer
                moveDisks(n - 1, buffer, destination);
                //move top
                moveTopTo(destination);

                //move n-1 disks from buffer to destination
                buffer.moveDisks(n - 1, destination, this);
            }
        }
    }

}
