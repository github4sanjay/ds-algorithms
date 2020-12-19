package stack;

import linkedlist.structure.LinkNode;

public class LinkedStack<T> {
    private LinkNode<T> top;
    private int length;

    public LinkedStack() {
        this.top = null;
        this.length = 0;
    }

    public void push(T data){
        var newNode = new LinkNode<>(data, null);
        newNode.setNext(top);
        top = newNode;
        length++;
    }

    public int size(){
        return length;
    }

    public boolean isEmpty() throws Exception {
        return size() == 0;
    }

    public T pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        var data = top.getData();
        top = top.getNext();
        length--;
        return data;
    }

    public T peek() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        return top.getData();
    }

    public static void main(String[] args) throws Exception {
        var stack = new LinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
