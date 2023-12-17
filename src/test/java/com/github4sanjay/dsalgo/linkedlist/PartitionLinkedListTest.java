package com.github4sanjay.dsalgo.linkedlist;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartitionLinkedListTest {

  @Test
  public void testPartitionLinkedList() throws Exception {
    var linkedList = new LinkedList<Integer>();
    linkedList.addLast(1);
    linkedList.addLast(3);
    linkedList.addLast(5);
    linkedList.addLast(2);
    linkedList.addLast(4);
    linkedList.addLast(8);
    linkedList.addLast(10);
    String text =
        tapSystemOut(
            () -> LinkedListUtil.print(PartitionLinkedList.partition(linkedList.getHead(), 9)));

    Assertions.assertEquals(
        """
                                  1
                                  3
                                  5
                                  2
                                  4
                                  8
                                  10
                                  """,
        text);
  }
}
