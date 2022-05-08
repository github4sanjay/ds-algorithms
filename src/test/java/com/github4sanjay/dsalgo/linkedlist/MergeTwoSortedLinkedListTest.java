package com.github4sanjay.dsalgo.linkedlist;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedListUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MergeTwoSortedLinkedListTest {

  @Test
  @DisplayName("test merge two sorted linked list")
  public void testMergeInLinkedListUtil() throws Exception {
    LinkedList<Integer> linkedList = new LinkedList<>();

    linkedList.addLast(10);
    linkedList.addLast(20);
    linkedList.addLast(30);
    linkedList.addLast(34);

    LinkedList<Integer> anotherLL = new LinkedList<>();
    anotherLL.addLast(1);
    anotherLL.addLast(2);
    anotherLL.addLast(3);
    String text =
        tapSystemOut(
            () -> LinkedListUtil.mergeSorted(linkedList.getHead(), anotherLL.getHead()).print());

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
  @DisplayName("test merge two sorted linked list")
  public void testMerge() throws Exception {
    LinkedList<Integer> linkedList = new LinkedList<>();

    linkedList.addLast(10);
    linkedList.addLast(20);
    linkedList.addLast(30);
    linkedList.addLast(34);

    LinkedList<Integer> anotherLL = new LinkedList<>();
    anotherLL.addLast(1);
    anotherLL.addLast(2);
    anotherLL.addLast(3);
    String text =
        tapSystemOut(
            () ->
                LinkedListUtil.print(
                    MergeTwoSortedLinkedList.merge(linkedList.getHead(), anotherLL.getHead())));

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
