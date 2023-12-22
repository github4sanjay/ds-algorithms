package com.github4sanjay.dsalgo.hashmap.structure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashMapTest {

  @Test
  public void test() {
    var map = new HashMap<Integer, Integer>(2);
    map.put(1, 1);
    map.put(2, 2);
    map.put(3, 3);
    map.put(4, 4);
    map.put(5, 5);

    Assertions.assertTrue(map.containsKey(4)); // true
    map.remove(4);
    Assertions.assertFalse(map.containsKey(4)); // false
    Assertions.assertEquals("[1, 2, 3, 5]", map.keySet().toString());
    Assertions.assertEquals("[1, 2, 3, 5]", map.values().stream().sorted().toList().toString());

    assertNull(map.get(4));

    Assertions.assertEquals(3, map.get(3));
  }
}
