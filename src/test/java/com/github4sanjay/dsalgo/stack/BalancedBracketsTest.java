package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BalancedBracketsTest {

  @Test
  public void testIsBalanced() {
    assertTrue(BalancedBrackets.isBalanced("[()]{}{[()()]()}"));
    assertFalse(BalancedBrackets.isBalanced("[(])"));
    assertTrue(BalancedBrackets.isBalanced("[(a + b) + {(c + d) * (e / f)}]"));
    assertFalse(BalancedBrackets.isBalanced("[(a + b) + {(c + d) * (e / f)]}"));
    assertFalse(BalancedBrackets.isBalanced("[(a + b) + {(c + d) * (e / f)}"));
    assertFalse(BalancedBrackets.isBalanced("([(a + b) + {(c + d) * (e / f)}]"));
  }
}
