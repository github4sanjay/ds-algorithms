package com.github4sanjay.dsalgo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrisonBreakTest {

  @Test
  void minimumGroups() {
    Assertions.assertEquals(9, PrisonBreak.minimumGroups(4, 4, List.of(1, 3, 4), List.of(2, 3)));
    Assertions.assertEquals(4, PrisonBreak.minimumGroups(6, 5, List.of(2, 4), List.of(1, 4)));
    Assertions.assertEquals(4, PrisonBreak.minimumGroups(3, 3, List.of(2), List.of(2)));
  }
}
