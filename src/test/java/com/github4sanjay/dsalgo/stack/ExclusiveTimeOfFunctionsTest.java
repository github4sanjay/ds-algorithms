package com.github4sanjay.dsalgo.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExclusiveTimeOfFunctionsTest {

  @Test
  public void find1() {
    var result =
        ExclusiveTimeOfFunctions.find(
            2, new String[] {"0:start:0", "1:start:2", "1:end:5", "0:end:6"});
    var expected = new int[] {3, 4};
    for (int i = 0; i < expected.length; i++) {
      Assertions.assertEquals(expected[i], result[i]);
    }
  }

  @Test
  public void find2() {
    var result =
        ExclusiveTimeOfFunctions.find(
            1,
            new String[] {"0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"});
    var expected = new int[] {8};
    for (int i = 0; i < expected.length; i++) {
      Assertions.assertEquals(expected[i], result[i]);
    }
  }

  @Test
  public void find3() {
    var result =
        ExclusiveTimeOfFunctions.find(
            2,
            new String[] {"0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"});
    var expected = new int[] {7, 1};
    for (int i = 0; i < expected.length; i++) {
      Assertions.assertEquals(expected[i], result[i]);
    }
  }
}
