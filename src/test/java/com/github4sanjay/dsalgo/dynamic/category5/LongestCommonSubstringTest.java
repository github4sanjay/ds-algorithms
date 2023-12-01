package com.github4sanjay.dsalgo.dynamic.category5;

import com.github4sanjay.dsalgo.dynamic.strings.LongestCommonSubstring;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestCommonSubstringTest {

  @Test
  public void find() {
    Assertions.assertEquals(3, LongestCommonSubstring.find("pqabcxy", "xyzabcp"));
    Assertions.assertEquals(4, LongestCommonSubstring.find("abcdgh", "acdghr"));
  }
}
