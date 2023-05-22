package com.github4sanjay.dsalgo.java.concurrency;

import java.util.concurrent.*;

public class PhaserAsCountDownLatchTest {
  public static void main(String[] args) {
    var phaser = new Phaser(4);
    new Thread(new Task("Task1", phaser)).start();
    new Thread(new Task("Task2", phaser)).start();
    new Thread(new Task("Task3", phaser)).start();
    phaser.arriveAndAwaitAdvance();
    System.out.println("All task completed");
  }

  public static class Task implements Runnable {
    private final String name;
    private final Phaser phaser;

    public Task(String name, Phaser phaser) {
      this.name = name;
      this.phaser = phaser;
    }

    @Override
    public void run() {
      System.out.println("Arrived : " + name);
      phaser.arrive();
    }
  }
}
