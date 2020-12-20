package stack.structure;

import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
 * and an additional operation getMin() which should return minimum element from the SpecialStack.
 * All these operations of SpecialStack must be O(1). T
 * o implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list, .. etc.
 *
 * Example:
 *
 * Consider the following SpecialStack
 * 16  --> TOP
 * 15
 * 29
 * 19
 * 18
 *
 * When getMin() is called it should return 15,
 * which is the minimum element in the current stack.
 *
 * If we do pop two times on stack, the stack becomes
 * 29  --> TOP
 * 19
 * 18
 *
 * When getMin() is called, it should return 18
 * which is the minimum in the current stack.
 */
public class MinStack<T extends Comparable<T>> {
    private final Stack<T> stack;
    private final Stack<T> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public T getMin(){
        return minStack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }

    public T pop() {
        minStack.pop();
        return stack.pop();
    }

    public void push(T data) {
        stack.push(data);
        if (minStack.isEmpty() || data.compareTo(minStack.peek()) < 0){
            minStack.push(data);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public static void main(String[] args) {
        var minStack = new MinStack<Integer>();
        minStack.push(10);
        System.out.println(minStack.getMin());

        minStack.push(5);
        System.out.println(minStack.getMin());

        minStack.push(15);
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
