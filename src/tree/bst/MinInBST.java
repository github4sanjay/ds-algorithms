package tree.bst;

import tree.binary.structure.BinaryNode;

public class MinInBST {

    public static void main(String[] args) {
        var root = BSTUtil.create(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(MinInBST.recursive(root)); // 1
    }

    public static int recursive(BinaryNode root) {
        if (root.getLeft() == null){
            return root.getData();
        } else {
          return recursive(root.getLeft());
        }
    }
}
