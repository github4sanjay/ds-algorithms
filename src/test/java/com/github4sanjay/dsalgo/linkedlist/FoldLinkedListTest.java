package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class FoldLinkedListTest {

  @Test
  public void testFold() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);
    list.addLast(6);
    list.addLast(7);
    list.addLast(8);

    FoldLinkedList.fold(list.getHead());

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    list.print();

    String expectedOutput =
        """
        1
        8
        2
        7
        3
        6
        4
        5
        """;
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testFoldWithStack() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
    list.addLast(4);
    list.addLast(5);
    list.addLast(6);
    list.addLast(7);
    list.addLast(8);

    FoldLinkedList.foldWithStack(list);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    list.print();

    String expectedOutput =
        """
            1
            8
            2
            7
            3
            6
            4
            5
            """;
    assertEquals(expectedOutput, outContent.toString());
  }
}
