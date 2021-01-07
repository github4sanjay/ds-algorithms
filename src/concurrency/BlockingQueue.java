package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private final Lock lock;
    private final Condition itemAdded;
    private final Condition itemRemoved;
    private final Queue<T> queue;
    private final int size;

    public BlockingQueue(int size) {
        this.queue = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.itemAdded = this.lock.newCondition();
        this.itemRemoved = this.lock.newCondition();
        this.size = size;
    }

    public void add(T item) throws InterruptedException {
        try {
            lock.lock();
            while (queue.size() == size){
                itemRemoved.await();
            }
            queue.offer(item);
            itemAdded.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public T remove() throws InterruptedException {
        try {
            lock.lock();
            while (queue.size() == 0){
                itemAdded.await();
            }
            itemRemoved.signalAll();
            return queue.poll();
        } finally {
            lock.unlock();
        }

    }
}
