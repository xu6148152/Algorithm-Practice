import com.example.stack_queue.StackWithNode;

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

}
