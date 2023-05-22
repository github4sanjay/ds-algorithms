package com.github4sanjay.dsalgo.java.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

  public static void main(String[] args) throws InterruptedException {
    var executer = Executors.newFixedThreadPool(10);
    var atomicInteger = new AtomicInteger();
    for (int i = 0; i < 100; i++) {
      executer.submit(new Task(atomicInteger));
    }
    Thread.sleep(10000);
    System.out.println(atomicInteger.get());
    executer.shutdown();
  }

  public static class Task implements Runnable {
    private final AtomicInteger atomicInteger;

    public Task(AtomicInteger atomicInteger) {
      this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
      atomicInteger.incrementAndGet();
    }
  }
}
