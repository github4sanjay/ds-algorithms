package com.github4sanjay.dsalgo.dynamic.category2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FriendsPairingTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(4, FriendsPairing.recursion(3));
    Assertions.assertEquals(2, FriendsPairing.recursion(2));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(4, FriendsPairing.memoization(3));
    Assertions.assertEquals(2, FriendsPairing.recursion(2));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(4, FriendsPairing.tabulation(3));
    Assertions.assertEquals(2, FriendsPairing.recursion(2));
  }
}
