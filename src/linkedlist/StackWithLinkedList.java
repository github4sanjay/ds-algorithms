package linkedlist;

import java.util.LinkedList;

public class StackWithLinkedList<T> {

    LinkedList<T> list;

    public StackWithLinkedList() {
        this.list = new LinkedList<>();
    }

    public void push(T item) {
        list.addFirst(item);
    }

    public T top() {
        return list.getFirst();
    }

    public T pop() {
        if (list.size() == 0){
            throw new RuntimeException("List is empty");
        }
        return list.removeFirst();
    }

    public static void main(String[] args) {
        var stack = new StackWithLinkedList<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
