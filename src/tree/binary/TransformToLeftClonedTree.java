package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;
import util.AlgoUtil;

/**
 * Clone root to left and attach previous left to cloned node
 */
public class TransformToLeftClonedTree {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, -1, -1, 75, 62, -1, -1, 87, -1, -1});
        AlgoUtil.print(BinaryTreeUtil.display(root));
        System.out.println();

        TransformToLeftClonedTree.recursive(root);
        AlgoUtil.print(BinaryTreeUtil.display(root));
    }

    private static void recursive(BinaryNode root) {
        if (root == null) return;
        recursive(root.getLeft());
        recursive(root.getRight());

        var prevLeft = root.getLeft();
        root.setLeft(new BinaryNode(root.getData(), prevLeft, null));
    }
}
