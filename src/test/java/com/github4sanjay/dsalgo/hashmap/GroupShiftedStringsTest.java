package com.github4sanjay.dsalgo.hashmap;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GroupShiftedStringsTest {

  @Test
  public void test() throws Exception {
    String text =
        tapSystemOut(
            () ->
                System.out.print(
                    GroupShiftedStrings.find(
                        List.of("acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"))));
    Assertions.assertEquals(text, "[[a, x], [bdfh, moqs], [acd, dfg, wyz, yab, mop]]");
  }
}
