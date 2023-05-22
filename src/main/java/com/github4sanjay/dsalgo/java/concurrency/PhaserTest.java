package com.github4sanjay.dsalgo.java.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {
  public static void main(String[] args) throws InterruptedException {
    var execute = Executors.newFixedThreadPool(4);
    var phaser = new Phaser(1);
    execute.submit(new Task("Task1", phaser));
    execute.submit(new Task("Task2", phaser));
    execute.submit(new Task("Task3", phaser));
    phaser.arriveAndAwaitAdvance();

    execute.submit(new Task("Task4", phaser));
    execute.submit(new Task("Task5", phaser));
    phaser.arriveAndAwaitAdvance();
    Thread.sleep(3000);
    System.out.println(phaser.getRegisteredParties());
    phaser.arriveAndDeregister();
    Thread.sleep(3000);
    System.out.println(phaser.getRegisteredParties());
    execute.shutdown();
  }

  public static class Task implements Runnable {
    private final String name;
    private final Phaser phaser;

    public Task(String name, Phaser phaser) {
      phaser.register();
      this.name = name;
      this.phaser = phaser;
    }

    @Override
    public void run() {
      System.out.println("Arrived : " + name);
      phaser.arriveAndAwaitAdvance();
      System.out.println("Next : " + name);
      phaser.arriveAndDeregister();
    }
  }
}
