package queue.structure;

public class DynamicArrayQueue {
    private static int DEFAULT_CAPACITY = 10;
    private int[] repo;
    private int front;
    private int size;

    public DynamicArrayQueue() {
        this.repo = new int[DEFAULT_CAPACITY];
        this.front = 0;
        this.size = 0;
    }

    public void add(int data) {
        if (size == repo.length){
            increaseSize();
        }
        int rear = (front + size) % repo.length;
        repo[rear] = data;
        size++;
    }

    private void increaseSize() {
        int[] newRepo = new int[size*2];
        for (int i=0; i< size; i++){
            newRepo[i] = repo[(front+i) % repo.length];
        }
        this.repo = newRepo;
        this.front = 0;
    }

    public void display() {
        for (int i=0; i< size; i++){
            System.out.println(repo[(front+i)%repo.length]);
        }
    }

    public int remove() {
        if (size == 0){
            throw new RuntimeException("queue is empty");
        }
        int data = repo[front];
        front = (front + 1)/repo.length;
        size--;
        return data;
    }

    public int peek(){
        if (size == 0){
            throw new RuntimeException("queue is empty");
        }
        return repo[front];
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        DynamicArrayQueue queue = new DynamicArrayQueue();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);
        queue.add(110);
        queue.add(120);
        queue.display();
    }
}
