package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.Node;

import java.util.LinkedList;

public class FindInGenericTree {

    public static void main(String[] args) {
        var root = GenericTree.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(FindInGenericTree.find(root, 40));
        System.out.println(FindInGenericTree.findRecursion(root, 40));

        System.out.println(FindInGenericTree.find(root, 140));
        System.out.println(FindInGenericTree.findRecursion(root, 140));

    }

    private static boolean find(Node root, int find) {
        var queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node.getData() == find){
                return true;
            }
            for (var child : node.getChildren()){
                queue.offer(child);
            }
        }
        return false;
    }

    private static boolean findRecursion(Node root, int find) {
        if (root.getData() == find){
            return true;
        }
        for (var child : root.getChildren()){
            if (findRecursion(child, find)){
                return true;
            }
        }
        return false;
    }
}
