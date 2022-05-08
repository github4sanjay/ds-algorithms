package com.github4sanjay.dsalgo.linkedlist;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedListUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SegregateEvenOddNodesTest {

  @Test
  public void testSegregateOddEvenNodes() throws Exception {
    var linkedList = new LinkedList<Integer>();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    linkedList.addLast(6);
    String text =
        tapSystemOut(
            () -> LinkedListUtil.print(SegregateEvenOddNodes.segregate(linkedList.getHead())));

    Assertions.assertEquals(
        """
                          1
                          3
                          5
                          2
                          4
                          6
                          """,
        text);
  }

  @Test
  public void testSegregateOddEvenNodesWhenJustEven() throws Exception {
    var linkedList = new LinkedList<Integer>();
    linkedList.addLast(2);
    linkedList.addLast(4);
    linkedList.addLast(6);
    String text =
        tapSystemOut(
            () -> LinkedListUtil.print(SegregateEvenOddNodes.segregate(linkedList.getHead())));

    Assertions.assertEquals(
        """
                          2
                          4
                          6
                          """,
        text);
  }

  @Test
  public void testSegregateOddEvenNodesWhenJustOdd() throws Exception {
    var linkedList = new LinkedList<Integer>();
    linkedList.addLast(1);
    linkedList.addLast(3);
    linkedList.addLast(5);
    String text =
        tapSystemOut(
            () -> LinkedListUtil.print(SegregateEvenOddNodes.segregate(linkedList.getHead())));

    Assertions.assertEquals(
        """
                          1
                          3
                          5
                          """,
        text);
  }

  @Test
  public void testSegregateOddEvenNodesWhenAlreadySegregated() throws Exception {
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
            () -> LinkedListUtil.print(SegregateEvenOddNodes.segregate(linkedList.getHead())));

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
