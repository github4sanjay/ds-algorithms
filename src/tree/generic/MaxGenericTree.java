package tree.generic;

import tree.generic.structure.GenericTreeUtil;
import tree.generic.structure.Node;

import java.util.LinkedList;

public class MaxGenericTree {

    public static void main(String[] args) {
        var root = GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(MaxGenericTree.find(root));
        System.out.println(MaxGenericTree.findRecursion(root));
    }

    private static int find(Node root) {
        var queue = new LinkedList<Node>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            var node = queue.poll();
            max = Math.max(max, node.getData());
            for (var child : node.getChildren()){
                queue.offer(child);
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
