package tree.bst;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;

public class AddNodeInBST {

    public static void main(String[] args) {
        int n = -1;
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, n, n, 37, 30, n, n, 40, n, n, 75, 62, 60, n, n, 70, n, n, 87, n, n});
        BSTUtil.inOrder(root);
        System.out.println();
        AddNodeInBST.add(root, 61);
        BSTUtil.inOrder(root);
    }

    private static BinaryNode add(BinaryNode root, int data) {
        if (root == null){
            return new BinaryNode(data);
        }
        if (data < root.getData()){
            root.setLeft(add(root.getLeft(), data));
        } else {
            root.setRight(add(root.getRight(), data));
        }
        return root;
    }
}
