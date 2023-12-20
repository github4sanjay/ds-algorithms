package com.github4sanjay.dsalgo.tree.generic;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PostOrderGenericTreeTest {

  @Test
  public void testPostOrderGenericTree() {
    var root =
        GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
    var expected = List.of(20, 50, 60, 30, 40, 10);
    Assertions.assertEquals(expected, PostOrderGenericTree.traverse(root));
    Assertions.assertEquals(expected, PostOrderGenericTree.traverseRecursion(root));
  }
}
