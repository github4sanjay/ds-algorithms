package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderGenericTree {

    public static void main(String[] args) {
        var root = GenericTree.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(LevelOrderGenericTree.traverse(root));
    }

    // use queue
    private static List<Integer> traverse(Node root) {
        var queue = new LinkedList<Node>();
        queue.offer(root);
        var list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            var node = queue.poll();
            list.add(node.getData());
            for (var child : node.getChildren()){
                queue.offer(child);
            }
        }
        return list;
    }
}
