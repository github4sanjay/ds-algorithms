package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.Node;

import java.util.LinkedList;

public class MaxGenericTree {

    public static void main(String[] args) {
        var root = GenericTree.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(MaxGenericTree.find(root));
        System.out.println(MaxGenericTree.findRecursion(root));
    }

    private static int find(Node root) {
        var queue = new LinkedList<Node>();
        queue.push(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            var node = queue.pop();
            max = Math.max(max, node.getData());
            for (var child : node.getChildren()){
                queue.push(child);
            }
        }
        return max;
    }

    private static int findRecursion(Node root) {
        return findRecursion(root, Integer.MIN_VALUE);
    }

    private static int findRecursion(Node root, int max) {

        for (var child : root.getChildren()){
            max = Math.max(max, find(child));
        }
        return Math.max(max, root.getData());
    }
}
