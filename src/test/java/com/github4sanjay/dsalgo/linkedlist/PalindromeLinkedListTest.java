package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import org.junit.jupiter.api.Test;

public class PalindromeLinkedListTest {

  @Test
  public void testIsPalindrome() {
    // Test a palindrome list
    LinkedList<Integer> palindromeHeadLinkedList = new LinkedList<>();
    palindromeHeadLinkedList.addLast(10);
    palindromeHeadLinkedList.addLast(20);
    palindromeHeadLinkedList.addLast(30);
    palindromeHeadLinkedList.addLast(40);
    palindromeHeadLinkedList.addLast(30);
    palindromeHeadLinkedList.addLast(20);
    palindromeHeadLinkedList.addLast(10);

    assertTrue(PalindromeLinkedList.isPalindrome(palindromeHeadLinkedList.getHead()));

    LinkedList<Integer> nonPalindromeLinkedList = new LinkedList<>();
    nonPalindromeLinkedList.addLast(10);
    nonPalindromeLinkedList.addLast(20);
    nonPalindromeLinkedList.addLast(30);
    nonPalindromeLinkedList.addLast(40);
    nonPalindromeLinkedList.addLast(30);
    nonPalindromeLinkedList.addLast(20);
    nonPalindromeLinkedList.addLast(70);

    assertFalse(PalindromeLinkedList.isPalindrome(nonPalindromeLinkedList.getHead()));
  }

  @Test
  public void testIsPalindromeWithStack() {
    // Test a palindrome list
    LinkedList<Integer> palindromeHeadLinkedList = new LinkedList<>();
    palindromeHeadLinkedList.addLast(10);
    palindromeHeadLinkedList.addLast(20);
    palindromeHeadLinkedList.addLast(30);
    palindromeHeadLinkedList.addLast(40);
    palindromeHeadLinkedList.addLast(30);
    palindromeHeadLinkedList.addLast(20);
    palindromeHeadLinkedList.addLast(10);

    assertTrue(PalindromeLinkedList.isPalindromeWithStack(palindromeHeadLinkedList));

    LinkedList<Integer> nonPalindromeLinkedList = new LinkedList<>();
    nonPalindromeLinkedList.addLast(10);
    nonPalindromeLinkedList.addLast(20);
    nonPalindromeLinkedList.addLast(30);
    nonPalindromeLinkedList.addLast(40);
    nonPalindromeLinkedList.addLast(30);
    nonPalindromeLinkedList.addLast(20);
    nonPalindromeLinkedList.addLast(70);

    assertFalse(PalindromeLinkedList.isPalindromeWithStack(nonPalindromeLinkedList));
  }
}
