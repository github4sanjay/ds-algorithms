package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

/*
 * Add two numbers represented by linked lists | Set 2 Given two numbers represented by two linked
 * lists, write a function that returns the sum list. The sum list is linked list representation of
 * the addition of two input numbers. It is not allowed to modify the lists. Also, not allowed to
 * use explicit extra space (Hint: Use Recursion).
 *
 * Example :
 *
 * Input:
 *   First List: 5->6->3
 *   Second List: 8->4->2
 * Output
 *   Resultant list: 1->4->0->5
 */
public class AddTwoLinkedLists {

  /*
   *  Take 9 -> 8 -> 7
   *            6 -> 5
   *
   *       Stack
   *   ________________
   *  | null-0, null-0 |_________
   *  |________________|        | carry 0
   *  |   7-1, 5-1     | _______|
   *  |________________|        |carry 1
   *  |   8-2, 6-2     |________|
   *  |________________|
   *  |   9-3, 6-2     |
   *  |________________|
   *
   */
  public static LinkedList<Integer> add(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    var result = new LinkedList<Integer>();
    var lastCarry = add(list1.getHead(), list1.getSize(), list2.getHead(), list2.getSize(), result);
    if (lastCarry > 0) {
      result.addFirst(lastCarry);
    }
    return result;
  }

  private static int add(
      LinkNode<Integer> head1,
      int size1,
      LinkNode<Integer> head2,
      int size2,
      LinkedList<Integer> result) {
    if (head1 == null && head2 == null) {
      return 0; // return carry 0
    }
    if (size1 > size2) {
      var carry = add(head1.getNext(), size1 - 1, head2, size2, result);
      var sum = head1.getData() + carry;
      var newCarry = sum / 10;
      result.addFirst(sum % 10);
      return newCarry;
    } else if (size2 > size1) {
      var carry = add(head1, size1, head2.getNext(), size2 - 1, result);
      var sum = head2.getData() + carry;
      var newCarry = sum / 10;
      result.addFirst(sum % 10);
      return newCarry;
    } else {
      var carry = add(head1.getNext(), size1 - 1, head2.getNext(), size2 - 1, result);
      var sum = head1.getData() + head2.getData() + carry;
      var newCarry = sum / 10;
      result.addFirst(sum % 10);
      return newCarry;
    }
  }

  public static LinkedList<Integer> addReversing(
      LinkedList<Integer> list1, LinkedList<Integer> list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    list1.reverse();
    list2.reverse();
    var newList = new LinkedList<Integer>();
    var curr1 = list1.getHead();
    var curr2 = list2.getHead();
    int carry = 0;
    while (curr1 != null && curr2 != null) {
      int sum = curr1.getData() + curr2.getData() + carry;
      newList.addFirst(sum % 10);
      carry = sum / 10;
      curr1 = curr1.getNext();
      curr2 = curr2.getNext();
    }

    if (curr1 != null) {
      while (curr1 != null) {
        int sum = curr1.getData() + carry;
        newList.addFirst(sum % 10);
        carry = sum / 10;
        curr1 = curr1.getNext();
      }
    }

    if (curr2 != null) {
      while (curr2 != null) {
        int sum = curr2.getData() + carry;
        newList.addFirst(sum % 10);
        carry = sum / 10;
        curr2 = curr2.getNext();
      }
    }
    if (carry > 0) {
      newList.addFirst(carry);
    }
    return newList;
  }
}
