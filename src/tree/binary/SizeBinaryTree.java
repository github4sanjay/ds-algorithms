package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;
import util.AlgoUtil;

import java.util.Stack;

public class SizeBinaryTree {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
        System.out.println(SizeBinaryTree.recursive(root));
        System.out.println(SizeBinaryTree.iterative(root));
    }

    // preorder
    private static int iterative(BinaryNode root) {
        if (root == null) return 0;
        var stack = new Stack<BinaryNode>();
        stack.push(root);
        int size = 0;
        while (!stack.isEmpty()){
            size++;
            var node = stack.pop();
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
        return size;
    }

    private static int recursive(BinaryNode root) {
        if (root == null){
            return 0;
        }
        int sizeLeft = recursive(root.getLeft());
        int sizeRight = recursive(root.getRight());
        return sizeLeft + sizeRight + 1;
    }
}
