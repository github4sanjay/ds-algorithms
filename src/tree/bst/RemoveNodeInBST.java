package tree.bst;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;

public class RemoveNodeInBST {

    public static void main(String[] args) {
        int n = -1;
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, n, n, 37, 30, n, n, 40, n, n, 75, 62, 60, n, n, 70, n, n, 87, n, n});
        BSTUtil.inOrder(root);
        System.out.println();
        RemoveNodeInBST.remove(root, 60);
        BSTUtil.inOrder(root);
    }

    private static BinaryNode remove(BinaryNode root, int data) {

        if (data < root.getData()){
            root.setLeft(remove(root.getLeft(), data));
        } else if (data > root.getData()){
            root.setRight(remove(root.getRight(), data));
        } else {
            if (root.getLeft() == null && root.getRight() == null){
                return null;
            } else if (root.getLeft() == null){
                return root.getRight();
            } else if (root.getRight() == null){
                return root.getLeft();
            } else {
                var maxInLeft = MaxInBST.recursive(root.getLeft());
                root.setData(maxInLeft);
                remove(root.getLeft(), maxInLeft);
            }
        }
        return root;
    }
}
