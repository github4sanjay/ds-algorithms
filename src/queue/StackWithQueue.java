package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

    private final Queue<Integer> queue1;
    private final Queue<Integer> queue2;

    public StackWithQueue() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public boolean isEmpty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public int size(){
        return queue1.size()+ queue2.size();
    }

    public int pop() {
        if (queue1.isEmpty()){
            while (queue2.size() != 1){
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        } else {
            while (queue1.size() != 1){
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }
    }

    public void push(int data) {
        if (queue1.isEmpty()){
            queue2.add(data);
        } else {
            queue1.add(data);
        }
    }

    public static void main(String[] args) {
        var stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop()); // 2
        stack.push(4);
        stack.push(3);
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 4
    }
}
