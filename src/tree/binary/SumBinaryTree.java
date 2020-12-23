package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;

import java.util.Stack;

public class SumBinaryTree {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
        System.out.println(SumBinaryTree.recursive(root));
        System.out.println(SumBinaryTree.iterative(root));
    }

    // preorder
    private static int iterative(BinaryNode root) {
        if (root == null) return 0;
        var stack = new Stack<BinaryNode>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()){
            var node = stack.pop();
            sum = sum + node.getData();
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
        return sum;
    }

    private static int recursive(BinaryNode root) {
        if (root == null){
            return 0;
        }
        int sumLeft = recursive(root.getLeft());
        int sumRight = recursive(root.getRight());
        return sumLeft + sumRight + root.getData();
    }
}
