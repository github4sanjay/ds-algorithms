package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        var execute = Executors.newFixedThreadPool(4);
        var cyclicBarrier = new CyclicBarrier(4);
        execute.submit(new Task("Task1", cyclicBarrier));
        execute.submit(new Task("Task2", cyclicBarrier));
        execute.submit(new Task("Task3", cyclicBarrier));

        cyclicBarrier.await();
        System.out.println("Phase 1 completed");
        cyclicBarrier.reset();

        execute.submit(new Task("Task4", cyclicBarrier));
        execute.submit(new Task("Task5", cyclicBarrier));
        execute.submit(new Task("Task6", cyclicBarrier));

        cyclicBarrier.await();
        System.out.println("Phase 2 completed");

        execute.shutdown();
    }

    public static class Task implements Runnable{
        private final String name;
        private final CyclicBarrier cyclicBarrier;

        public Task(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("Arrived : " + name);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Next : " + name);
        }
    }
}
