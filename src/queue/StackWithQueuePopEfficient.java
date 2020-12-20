package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * pop efficient
 */
public class StackWithQueuePopEfficient {

    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;

    public StackWithQueuePopEfficient() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public boolean isEmpty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public int size(){
        return queue1.size()+ queue2.size();
    }

    public int peek(){
        return queue1.peek();
    }

    public int pop() {
        return queue1.remove();
    }

    /**
     * if q1 is empty add it
     * else remove all elements from q1 to q2
     * add data in q1 and then add back all the elements from q2 to q1
     */
    public void push(int data) {
        if (queue1.isEmpty()){
            queue1.add(data);
        } else {
            while (!queue1.isEmpty()){
                queue2.add(queue1.remove());
            }
            queue1.add(data);
            while (!queue2.isEmpty()){
                queue1.add(queue2.remove());
            }
        }
    }

    public static void main(String[] args) {
        var stack = new StackWithQueuePopEfficient();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop()); // 2
        stack.push(4);
        stack.push(3);
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 4
    }
}
