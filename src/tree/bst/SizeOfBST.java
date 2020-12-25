package tree.bst;

import tree.binary.structure.BinaryNode;

public class SizeOfBST {

    public static void main(String[] args) {
        var root = BSTUtil.create(new int[]{12, 25, 37, 50, 62, 75, 87});
        System.out.println(SizeOfBST.recursive(root)); // 7
    }

    private static int recursive(BinaryNode root) {
        if (root == null){
            return 0;
        }
        var leftSize = recursive(root.getLeft());
        var rightSize = recursive(root.getRight());
        return leftSize + rightSize + 1;
    }
}
