package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.Node;

import java.util.LinkedList;

public class SizeGenericTree {

    public static void main(String[] args) {
        var root = GenericTree.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(SizeGenericTree.find(root));
        System.out.println(SizeGenericTree.findRecursion(root));
    }

    private static int find(Node root) {
        var queue = new LinkedList<Node>();
        queue.push(root);
        int count = 0;
        while (!queue.isEmpty()) {
            var node = queue.pop();
            count++;
            for (var child : node.getChildren()){
                queue.push(child);
            }
        }
        return count;
    }

    private static int findRecursion(Node root) {

        int count = 1;
        for (var child : root.getChildren()){
            count = count + find(child);
        }
        return count;
    }
}
