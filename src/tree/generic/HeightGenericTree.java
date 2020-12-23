package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.Node;

import java.util.LinkedList;

public class HeightGenericTree {

    public static void main(String[] args) {
        var root = GenericTree.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(HeightGenericTree.find(root));
        System.out.println(HeightGenericTree.findRecursion(root));
    }

    public static int find(Node root) {
        var queue = new LinkedList<Node>();
        queue.offer(root);
        queue.offer(null);
        int height = -1; // for edge height (keep 0 if want node height)
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node != null) {
                for (var child : node.getChildren()){
                    queue.offer(child);
                }
            } else {
                height++;
                if (!queue.isEmpty()) { // don't add if empty
                    queue.offer(null);
                }
            }

        }
        return height;
    }

    private static int findRecursion(Node root) {
        int height = -1;
        for (var child : root.getChildren()){
            height = Math.max(height, find(child));
        }
        return height + 1;
    }
}
