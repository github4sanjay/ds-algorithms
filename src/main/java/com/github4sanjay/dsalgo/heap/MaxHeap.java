package com.github4sanjay.dsalgo.heap;

/**
 * Heap is complete binary tree Follows heap order property either max or min
 *
 * <p>10, 20, 30, 40, 35, 45, 42, 55, 50
 *
 * <p>array is visualised as tree 10 / \ 20 30 / \ / \ 40 35 45 42 / \ 55 50
 *
 * <p>add -> logn remove -> logn peek -> 1
 */
public class MaxHeap {
  private int[] array;
  private int capacity;
  private int count;

  public MaxHeap(int capacity) {
    this.array = new int[capacity];
    this.capacity = capacity;
    this.count = 0;
  }

  public int parent(int i) {
    if (i <= 0 || i > count) {
      return -1;
    }
    return (i - 1) / 2;
  }

  public int leftChild(int i) {
    int left = 2 * i + 1;
    if (left >= this.count) return -1;
    return left;
  }

  public int rightChild(int i) {
    int right = 2 * i + 2;
    if (right >= this.count) return -1;
    return right;
  }

  public int getMax() {
    if (this.count == 0) {
      return -1;
    }
    return array[0];
  }

  public void percolateDown(int k) {
    int l = leftChild(k);
    int r = rightChild(k);
    int max;
    if (l != -1 && array[l] > array[k]) {
      max = l;
    } else {
      max = k;
    }

    if (r != -1 && array[r] > array[max]) {
      max = r;
    }

    if (max != k) {
      int temp = array[k];
      array[k] = array[max];
      array[max] = temp;
      percolateDown(max);
    }
  }

  public int deleteMax() {
    if (count == 0) {
      return -1;
    }
    int data = array[0];
    array[0] = array[count - 1];
    count--;
    percolateDown(0);
    return data;
  }

  public void insert(int data) {
    if (count == capacity) {
      resize();
    }
    count++;
    int i = count - 1;
    percolateUp(data, i);
  }

  private void percolateUp(int data, int i) {
    while (i > 0 && data > array[(i - 1) / 2]) {
      array[i] = array[(i - 1) / 2];
      i = (i - 1) / 2;
    }
    array[i] = data;
  }

  public int getCapacity() {
    return capacity;
  }

  private void resize() {
    int[] newArray = new int[2 * capacity];
    System.arraycopy(array, 0, newArray, 0, array.length);
    this.capacity = 2 * capacity;
    this.array = newArray;
  }
}
