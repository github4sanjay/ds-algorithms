package com.github4sanjay.dsalgo.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {
  private final PriorityQueue<Integer> max;
  private final PriorityQueue<Integer> min;

  public MedianPriorityQueue() {
    this.max = new PriorityQueue<>(Collections.reverseOrder());
    this.min = new PriorityQueue<>();
  }

  public void add(Integer data) {
    if (data == null) return;
    if (!min.isEmpty() && data > min.peek()) {
      min.add(data);
      if (min.size() - max.size() > 1) {
        max.add(min.remove());
      }
    } else {
      max.add(data);
      if (max.size() - min.size() > 1) {
        min.add(max.remove());
      }
    }
  }

  public Integer peek() {
    if (max.size() >= min.size()) {
      return max.peek();
    }
    return min.peek();
  }

  public Integer getMedian() {
    if (max.size() >= min.size()) {
      return max.peek();
    }
    return min.peek();
  }

  public Integer remove() {
    if (max.size() >= min.size()) {
      return max.remove();
    }
    return min.remove();
  }
}
