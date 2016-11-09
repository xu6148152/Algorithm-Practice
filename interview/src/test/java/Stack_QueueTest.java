import com.example.stack_queue.StackWithNode;
import com.example.stack_queue.TowerStack;

import org.junit.Test;

/**
 * Created by binea on 2016/11/8.
 */

public class Stack_QueueTest {
    @Test
    public void testStack1() {
        StackWithNode stackWithNode = new StackWithNode();
        stackWithNode.push(new StackWithNode(). new Node(1));
        stackWithNode.push(new StackWithNode(). new Node(2));
        stackWithNode.push(new StackWithNode(). new Node(3));


//        System.out.println(stackWithNode.min().val);
        System.out.println(stackWithNode.pop().val);
        System.out.println(stackWithNode.pop().val);
        System.out.println(stackWithNode.pop().val);
    }

    @Test
    public void testTowerStack() throws Exception {
        int n = 3;
        int diskNums = 5;
        TowerStack.Tower[] towers = new TowerStack.Tower[n];
        for(int i = 0; i < 3; i++) {
            towers[i] = new TowerStack(). new Tower(i);
        }

        for(int i = diskNums; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(diskNums, towers[2], towers[1]);
    }

}
