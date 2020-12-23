package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.Stack;

public class HeightBinaryTree {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
        System.out.println(HeightBinaryTree.recursive(root));
        System.out.println(HeightBinaryTree.iterative(root));
    }

    // count levels in level order traversal
    private static int iterative(BinaryNode root) {
        var queue = new LinkedList<BinaryNode>();
        queue.offer(root);
        queue.offer(null);
        int height = -1;
        while (!queue.isEmpty()){
            var node = queue.poll();
            if (node != null){
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
            } else {
                height++;
                if (!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }
        return height;
    }

    private static int recursive(BinaryNode root) {
        if (root == null){
            return -1;
        }
        int heightLeft = recursive(root.getLeft());
        int heightRight = recursive(root.getRight());
        return Math.max(heightRight, heightLeft) + 1;
    }
}
