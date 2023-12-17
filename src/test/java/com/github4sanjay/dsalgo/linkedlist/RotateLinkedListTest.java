package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateLinkedListTest {

  @Test
  public void testRotateRight() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);
    list.addLast(6);
    list.addLast(7);
    list.addLast(8);
    int k = 3;

    var head = RotateLinkedList.rotateRight(list.getHead(), k);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    LinkedListUtil.print(head);

    var expectedOutput =
        """
               6
               7
               8
               1
               2
               3
               4
               5
               """;

    Assertions.assertEquals(expectedOutput, outContent.toString());
  }
}
