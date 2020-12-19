package stack.structure;

public class FixedSizeArrayStack {
    private static final int DEFAUT_CAPACITY = 10;
    private final int[] stackRepo;
    private final int capacity;
    private int top = -1;

    public FixedSizeArrayStack(int capacity) {
        this.capacity = capacity;
        stackRepo = new int[capacity];
    }

    public FixedSizeArrayStack(){
        this(DEFAUT_CAPACITY);
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public int size(){
        return top + 1;
    }

    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        int data = stackRepo[top];
        stackRepo[top--] = Integer.MIN_VALUE;
        return data;
    }

    public void push(int data) throws Exception {
        if (size() == capacity){
            throw new Exception("Stack is full");
        }
        stackRepo[++top] = data;
    }

    public static void main(String[] args) throws Exception {
        var stack = new FixedSizeArrayStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
