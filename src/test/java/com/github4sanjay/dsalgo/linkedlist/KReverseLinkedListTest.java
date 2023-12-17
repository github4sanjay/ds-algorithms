package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class KReverseLinkedListTest {

  @Test
  public void testKReverseLinkedList() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    linkedList.addLast(6);
    linkedList.addLast(7);
    linkedList.addLast(8);

    KReverseLinkedList.kReverseLinkedList(linkedList, 3);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    linkedList.print();

    String expectedOutput =
        """
        3
        2
        1
        6
        5
        4
        8
        7
        """;
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testKReverseLinkedListKeepingLastPartSame() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    linkedList.addLast(6);
    linkedList.addLast(7);
    linkedList.addLast(8);

    KReverseLinkedList.kReverseLinkedListKeepingLastPartSame(linkedList, 3);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    linkedList.print();

    String expectedOutput =
        """
        3
        2
        1
        6
        5
        4
        7
        8
        """;
    assertEquals(expectedOutput, outContent.toString());
  }
}
