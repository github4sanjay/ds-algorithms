package com.github4sanjay.dsalgo.linkedlist.structure;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class LinkedListTest {

  @Test
  public void testAddLast() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(5);
    list.addLast(10);
    list.addLast(15);

    assertEquals(3, list.getSize());
    assertEquals(5, (int) list.getHead().getData());
    assertEquals(15, (int) list.getTail().getData());

    LinkNode<Integer> currentNode = list.getHead();
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
    }
    assertEquals(15, (int) currentNode.getData());
  }

  @Test
  public void testReverse() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(5);
    list.addLast(10);
    list.addLast(15);

    list.reverse();

    assertEquals(3, list.getSize());
    assertEquals(15, (int) list.getHead().getData());
    assertEquals(5, (int) list.getTail().getData());

    LinkNode<Integer> currentNode = list.getHead();
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
    }
    assertEquals(5, (int) currentNode.getData());
  }

  @Test
  public void testReverseDataIterative() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(5);
    list.addLast(10);
    list.addLast(15);

    list.reverseDataIterative();

    assertEquals(3, list.getSize());
    assertEquals(15, (int) list.getHead().getData());
    assertEquals(5, (int) list.getTail().getData());

    // Ensure the data within nodes is reversed
    LinkNode<Integer> currentNode = list.getHead();
    int[] expectedData = {15, 10, 5};
    int index = 0;
    while (currentNode != null) {
      assertEquals(expectedData[index], (int) currentNode.getData());
      currentNode = currentNode.getNext();
      index++;
    }
  }

  @Test
  public void testPrint() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(5);
    list.addLast(10);
    list.addLast(15);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    list.print();

    String expectedOutput = "5\n10\n15\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testRemoveFirst() {
    LinkedList<Integer> list = new LinkedList<>();
    list.addLast(5);
    list.addLast(10);
    list.addLast(15);

    assertEquals(5, list.removeFirst());
    assertEquals(2, list.getSize());

    assertEquals(10, list.removeFirst());
    assertEquals(1, list.getSize());

    assertEquals(15, list.removeFirst());
    assertEquals(0, list.getSize());

    assertNull(list.removeFirst());
    assertEquals(0, list.getSize());
  }

  @Test
  public void testGetFirst() {
    LinkedList<Integer> list = new LinkedList<>();

    // Adding elements to the list
    list.addLast(5);
    list.addLast(10);
    list.addLast(15);

    // Checking if the first element matches the expected value
    assertEquals(5, list.getFirst());

    // Removing the first element and checking if it changes accordingly
    list.removeFirst();
    assertEquals(10, list.getFirst());

    // Removing all elements
    list.removeFirst();
    list.removeFirst();

    // Verifying the exception when trying to get the first element from an empty list
    assertThrows(RuntimeException.class, list::getFirst);
  }

  @Test
  public void testGetLast() {
    LinkedList<Integer> list = new LinkedList<>();

    // Adding elements to the list
    list.addLast(5);
    list.addLast(10);
    list.addLast(15);

    // Checking if the last element matches the expected value
    assertEquals(15, list.getLast());

    // Removing the last element and checking if it changes accordingly
    list.removeLast();
    assertEquals(10, list.getLast());

    // Removing all elements
    list.removeLast();
    list.removeLast();

    // Verifying the exception when trying to get the last element from an empty list
    assertThrows(RuntimeException.class, list::getLast);
  }

  @Test
  public void testGetAtIndex() {
    LinkedList<Integer> list = new LinkedList<>();

    // Adding elements to the list
    list.addLast(5);
    list.addLast(10);
    list.addLast(15);
    list.addLast(20);

    // Valid index test cases
    assertEquals(5, list.getAtIndex(0));
    assertEquals(10, list.getAtIndex(1));
    assertEquals(15, list.getAtIndex(2));
    assertEquals(20, list.getAtIndex(3));

    // Invalid index test case (index greater than size)
    assertThrows(RuntimeException.class, () -> list.getAtIndex(4));

    // Invalid index test case (index with empty list)
    list.removeFirst();
    list.removeFirst();
    list.removeFirst();
    list.removeFirst();
    assertThrows(RuntimeException.class, () -> list.getAtIndex(0));
  }

  @Test
  public void testAddFirst() {
    LinkedList<Integer> list = new LinkedList<>();

    // Adding elements using addFirst method
    list.addFirst(5);
    list.addFirst(10);
    list.addFirst(15);

    // Check if the size is updated correctly
    assertEquals(3, list.getSize());

    // Check if the elements are added at the beginning
    assertEquals(15, list.getFirst());
    assertEquals(5, list.getLast());
  }

  @Test
  public void testAddAtIndex() {
    LinkedList<Integer> list = new LinkedList<>();

    // Adding elements using addAtIndex method
    list.addAtIndex(0, 5);
    list.addAtIndex(1, 10);
    list.addAtIndex(1, 15);
    list.addAtIndex(2, 20);

    // Check if the size is updated correctly
    assertEquals(4, list.getSize());

    // Check if the elements are added at the specified indexes
    assertEquals(5, list.getAtIndex(0));
    assertEquals(15, list.getAtIndex(1));
    assertEquals(20, list.getAtIndex(2));
    assertEquals(10, list.getAtIndex(3));
  }

  @Test
  public void testRemoveLast() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add elements to the list
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    // Remove the last element
    int removed = list.removeLast();

    // Check the size after removal
    assertEquals(2, list.getSize());

    // Check if the last element is removed correctly
    assertEquals(30, removed);
    assertEquals(20, list.getLast());
  }

  @Test
  public void testRemoveAtIndex() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add elements to the list
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);

    // Remove an element at index 2
    int removed = list.removeAtIndex(2);

    // Check the size after removal
    assertEquals(3, list.getSize());

    // Check if the element at index 2 is removed correctly
    assertEquals(30, removed);
    assertEquals(40, list.getAtIndex(2));
  }

  @Test
  public void testGetNodeAtIndex() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add elements to the list
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);

    // Get the node at index 2
    LinkNode<Integer> node = list.getNodeAtIndex(2);

    // Check if the node retrieved is not null
    assertNotNull(node);

    // Check the data of the node at index 2
    assertEquals(30, node.getData());
  }

  @Test
  public void testGetNodeAtIndexOutOfBounds() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add elements to the list
    list.addLast(10);
    list.addLast(20);

    // Attempt to get node at index out of bounds
    assertThrows(RuntimeException.class, () -> list.getNodeAtIndex(5));
  }

  @Test
  public void testGetFromEnd() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add elements to the list
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);

    // Get the element k elements from the end
    int k = 2;
    int result = list.getFromEnd(k);

    // Check if the correct element from the end is retrieved
    assertEquals(20, result);
  }

  @Test
  public void testGetFromEndOutOfBounds() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add elements to the list
    list.addLast(10);
    list.addLast(20);

    // Attempt to get element from an out-of-bounds position
    assertThrows(RuntimeException.class, () -> list.getFromEnd(5));
  }

  @Test
  public void testGetMidEvenElements() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add even number of elements to the list
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);

    // Get the mid element
    int mid = list.getMid();

    // Check if the correct mid element is retrieved for even elements
    assertEquals(20, mid);
  }

  @Test
  public void testGetMidOddElements() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add odd number of elements to the list
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);
    list.addLast(50);

    // Get the mid element
    int mid = list.getMid();

    // Check if the correct mid element is retrieved for odd elements
    assertEquals(30, mid);
  }

  @Test
  public void testGetMidEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    // Attempt to get mid element from an empty list
    assertThrows(RuntimeException.class, list::getMid);
  }

  @Test
  public void testGetMidSingleElement() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add a single element to the list
    list.addLast(10);

    // Get the mid element from a single-element list
    int mid = list.getMid();

    // Check if the correct mid element is retrieved for a single element
    assertEquals(10, mid);
  }

  @Test
  public void testRemoveAtIndexFromLast() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add elements to the list
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);

    // Remove element at index 2 from the last
    int removed = list.removeAtIndexFromLast(2);

    // Check if the correct element is removed and list size is adjusted
    assertEquals(30, removed);
    assertEquals(3, list.getSize());
    assertEquals(10, list.getAtIndex(0));
    assertEquals(20, list.getAtIndex(1));
    assertEquals(40, list.getAtIndex(2));
  }

  @Test
  public void testRemoveAtIndexFromLastInvalidIndex() {
    LinkedList<Integer> list = new LinkedList<>();

    // Add elements to the list
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    // Attempt to remove an element with an invalid index
    assertThrows(RuntimeException.class, () -> list.removeAtIndexFromLast(3));
  }
}
