package com.github4sanjay.dsalgo.heap;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeKSortedListTest {

  @Test
  public void test() {
    Assertions.assertEquals(
        "[1, 1, 2, 3, 4, 4, 5, 6]",
        MergeKSortedList.merge(List.of(List.of(1, 4, 5), List.of(1, 3, 4), List.of(2, 6)))
            .toString());
  }
}
