package com.github4sanjay.dsalgo.java.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/** Better performance than AtomicInteger */
public class LongAdderTest {

  public static void main(String[] args) throws InterruptedException {
    var executer = Executors.newFixedThreadPool(10);
    var longAdder = new LongAdder();
    for (int i = 0; i < 100; i++) {
      executer.submit(new Task(longAdder));
    }
    Thread.sleep(5000);
    System.out.println(longAdder.sum());
    executer.shutdown();
  }

  public static class Task implements Runnable {
    private final LongAdder longAdder;

    public Task(LongAdder longAdder) {
      this.longAdder = longAdder;
    }

    @Override
    public void run() {
      longAdder.increment();
    }
  }
}
