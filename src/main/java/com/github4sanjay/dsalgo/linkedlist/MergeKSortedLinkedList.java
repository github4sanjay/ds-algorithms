package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MergeKSortedLinkedList {

  @Getter
  @AllArgsConstructor
  private static class Holder<T extends Comparable<T>> implements Comparable<Holder<T>> {
    private LinkNode<T> node;

    @Override
    public int compareTo(Holder<T> o) {
      return node.getData().compareTo(o.getNode().getData());
    }
  }

  // O(nk Log k)
  public static <T extends Comparable<T>> LinkNode<T> mergeUsingPriorityQueue(
      List<LinkNode<T>> heads) {
    var queue = new PriorityQueue<Holder<T>>();
    for (var head : heads) {
      if (head == null) continue;
      queue.add(new Holder<>(head));
    }
    var list = new LinkedList<T>();
    while (queue.size() > 0) {
      var head = queue.remove();
      list.addLast(head.getNode().getData());
      if (head.getNode().getNext() != null) {
        queue.add(new Holder<>(head.getNode().getNext()));
      }
    }
    return list.getHead();
  }

  // O(nk Log k)
  public static <T extends Comparable<T>> LinkNode<T> mergeUsingDivideAndConquer(
      List<LinkNode<T>> heads) {
    if (heads.size() == 0) return null;
    return mergeUsingDivideAndConquer(heads, 0, heads.size() - 1);
  }

  private static <T extends Comparable<T>> LinkNode<T> mergeUsingDivideAndConquer(
      List<LinkNode<T>> heads, int si, int ei) {
    if (si > ei) return null;
    if (si == ei) return heads.get(si);
    var mid = (si + ei) / 2;
    var head1 = mergeUsingDivideAndConquer(heads, si, mid);
    var head2 = mergeUsingDivideAndConquer(heads, mid + 1, ei);
    return MergeTwoSortedLinkedList.mergeWithoutCreatingNewLinkedList(head1, head2);
  }
}
