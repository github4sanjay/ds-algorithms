package com.github4sanjay.dsalgo.java.concurrency;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer<T> {

  private final ArrayBlockingQueue<T> queue;

  public ProducerConsumer(int capacity) {
    this.queue = new ArrayBlockingQueue<>(capacity);
  }

  public void produce(T data) {
    queue.offer(data);
  }

  public T consume() {
    return queue.poll();
  }
}
