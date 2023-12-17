package com.github4sanjay.dsalgo.linkedlist;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MergeKSortedLinkedListTest {

  @Test
  @DisplayName("test merge 3 sorted linked list with priority queue solution")
  public void testMerge3SortedLinkedListWithPriorityQueue() throws Exception {
    LinkedList<Integer> linkedList1 = new LinkedList<>();

    linkedList1.addLast(10);
    linkedList1.addLast(20);
    linkedList1.addLast(30);
    linkedList1.addLast(34);

    LinkedList<Integer> linkedList2 = new LinkedList<>();
    linkedList2.addLast(1);
    linkedList2.addLast(2);
    linkedList2.addLast(3);

    LinkedList<Integer> linkedList3 = new LinkedList<>();
    linkedList3.addLast(100);
    linkedList3.addLast(200);
    String text =
        tapSystemOut(
            () ->
                LinkedListUtil.print(
                    MergeKSortedLinkedList.mergeUsingPriorityQueue(
                        List.of(
                            linkedList1.getHead(), linkedList2.getHead(), linkedList3.getHead()))));

    Assertions.assertEquals(
        """
                1
                2
                3
                10
                20
                30
                34
                100
                200
                """,
        text);
  }

  @Test
  @DisplayName(
      "test merge 3 sorted linked list with priority queue solution when one list is empty")
  public void testMerge3SortedLinkedListWhenListIsEmptyWithPriorityQueue() throws Exception {
    LinkedList<Integer> linkedList1 = new LinkedList<>();

    linkedList1.addLast(10);
    linkedList1.addLast(20);
    linkedList1.addLast(30);
    linkedList1.addLast(34);

    LinkedList<Integer> linkedList2 = new LinkedList<>();
    linkedList2.addLast(1);
    linkedList2.addLast(2);
    linkedList2.addLast(3);

    LinkedList<Integer> linkedList3 = new LinkedList<>();
    var list = new ArrayList<LinkNode<Integer>>();
    list.add(linkedList1.getHead());
    list.add(linkedList2.getHead());
    list.add(linkedList3.getHead());
    String text =
        tapSystemOut(
            () -> LinkedListUtil.print(MergeKSortedLinkedList.mergeUsingPriorityQueue(list)));

    Assertions.assertEquals(
        """
                  1
                  2
                  3
                  10
                  20
                  30
                  34
                  """,
        text);
  }

  @Test
  @DisplayName("test merge 3 sorted linked list with divide and conquer solution")
  public void testMerge3SortedLinkedListWithDivideAndConquer() throws Exception {
    LinkedList<Integer> linkedList1 = new LinkedList<>();

    linkedList1.addLast(10);
    linkedList1.addLast(20);
    linkedList1.addLast(30);
    linkedList1.addLast(34);

    LinkedList<Integer> linkedList2 = new LinkedList<>();
    linkedList2.addLast(1);
    linkedList2.addLast(2);
    linkedList2.addLast(3);

    LinkedList<Integer> linkedList3 = new LinkedList<>();
    linkedList3.addLast(100);
    linkedList3.addLast(200);
    String text =
        tapSystemOut(
            () ->
                LinkedListUtil.print(
                    MergeKSortedLinkedList.mergeUsingDivideAndConquer(
                        List.of(
                            linkedList1.getHead(), linkedList2.getHead(), linkedList3.getHead()))));

    Assertions.assertEquals(
        """
                    1
                    2
                    3
                    10
                    20
                    30
                    34
                    100
                    200
                    """,
        text);
  }

  @Test
  @DisplayName("test merge 3 sorted linked list with divide and conquer when one list is empty")
  public void testMerge3SortedLinkedListWhenListIsEmptyWithDivideAndConquer() throws Exception {
    LinkedList<Integer> linkedList1 = new LinkedList<>();

    linkedList1.addLast(10);
    linkedList1.addLast(20);
    linkedList1.addLast(30);
    linkedList1.addLast(34);

    LinkedList<Integer> linkedList2 = new LinkedList<>();
    linkedList2.addLast(1);
    linkedList2.addLast(2);
    linkedList2.addLast(3);

    LinkedList<Integer> linkedList3 = new LinkedList<>();
    var list = new ArrayList<LinkNode<Integer>>();
    list.add(linkedList1.getHead());
    list.add(linkedList2.getHead());
    list.add(linkedList3.getHead());
    String text =
        tapSystemOut(
            () -> LinkedListUtil.print(MergeKSortedLinkedList.mergeUsingDivideAndConquer(list)));

    Assertions.assertEquals(
        """
                  1
                  2
                  3
                  10
                  20
                  30
                  34
                  """,
        text);
  }
}
