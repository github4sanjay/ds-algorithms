package com.github4sanjay.dsalgo.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

/** Generic version of LongAdder */
public class LongAccumulatorTest {

  public static void main(String[] args) throws InterruptedException {
    var executer = Executors.newFixedThreadPool(10);
    var longAccumulator = new LongAccumulator(Long::sum, 0);
    for (int i = 0; i < 100; i++) {
      executer.submit(new Task(longAccumulator));
    }
    Thread.sleep(5000);
    System.out.println(longAccumulator.get());
    executer.shutdown();
  }

  public static class Task implements Runnable {
    private final LongAccumulator longAccumulator;

    public Task(LongAccumulator longAccumulator) {
      this.longAccumulator = longAccumulator;
    }

    @Override
    public void run() {
      longAccumulator.accumulate(1);
    }
  }
}
