package com.github4sanjay.dsalgo.hashmap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfEmployeesUnderEveryManagerTest {

  @Test
  public void test() {
    var relations =
        new char[][] {
          {'A', 'C'},
          {'B', 'C'},
          {'C', 'F'},
          {'D', 'E'},
          {'E', 'F'},
          {'F', 'F'},
        };
    var map = NumberOfEmployeesUnderEveryManager.find(relations);
    Assertions.assertEquals(0, map.get('A'));
    Assertions.assertEquals(0, map.get('B'));
    Assertions.assertEquals(2, map.get('C'));
    Assertions.assertEquals(0, map.get('D'));
    Assertions.assertEquals(1, map.get('E'));
    Assertions.assertEquals(5, map.get('F'));
  }
}
