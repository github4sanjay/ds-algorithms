package com.github4sanjay.dsalgo.heap.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T extends Comparable<T>> {

  private final List<T> storage;
  private final Comparator<T> comparator;

  public Heap() {
    this.storage = new ArrayList<>();
    this.comparator = null;
  }

  public Heap(Comparator<T> comparator) {
    this.storage = new ArrayList<>();
    this.comparator = comparator;
  }

  public int getSize() {
    return storage.size();
  }

  public void add(T data) {
    storage.add(data);
    percolateUp(data, getSize() - 1);
  }

  public T get() {
    if (isEmpty()) {
      throw new RuntimeException("Heap is empty");
    }
    var removed = storage.get(0);
    storage.set(0, storage.get(storage.size() - 1));
    storage.remove(storage.size() - 1);
    percolateDown(0);
    return removed;
  }

  // O(log n)
  private void percolateDown(int index) {
    int leftChildIndex = getLeftChildIndex(index);
    int rightChildIndex = getRightChildIndex(index);
    int max = index;
    if (leftChildIndex != -1 && compare(storage.get(leftChildIndex), storage.get(index))) {
      max = leftChildIndex;
    }

    if (rightChildIndex != -1 && compare(storage.get(rightChildIndex), storage.get(max))) {
      max = rightChildIndex;
    }

    if (max != index) {
      T temp = storage.get(max);
      storage.set(max, storage.get(index));
      storage.set(index, temp);
      percolateDown(max);
    }
  }

  private int getLeftChildIndex(int index) {
    int i = 2 * index + 1;
    if (i >= getSize()) {
      return -1;
    }
    return i;
  }

  private int getRightChildIndex(int index) {
    int i = 2 * index + 2;
    if (i >= getSize()) {
      return -1;
    }
    return i;
  }

  private int getParent(int index) {
    if (index <= 0 || index > getSize()) {
      return -1;
    }
    return (index - 1) / 2;
  }

  public T peek() {
    if (isEmpty()) {
      throw new RuntimeException("Heap is empty");
    }
    return storage.get(0);
  }

  public boolean isEmpty() {
    return storage.isEmpty();
  }

  // O(log n)
  private void percolateUp(T data, int index) {
    while (index > 0 && compare(data, storage.get(getParent(index)))) {
      storage.set(index, storage.get((index - 1) / 2));
      index = getParent(index);
    }
    storage.set(index, data);
  }

  private boolean compare(T data1, T data2) {
    if (comparator == null) {
      return data1.compareTo(data2) < 0;
    } else {
      return comparator.compare(data1, data2) < 0;
    }
  }
}
