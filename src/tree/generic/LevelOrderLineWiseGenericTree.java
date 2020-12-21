package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderLineWiseGenericTree {

    public static void main(String[] args) {
        var root = GenericTree.createTree(new int[] {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1});
        System.out.println(LevelOrderLineWiseGenericTree.traverse(root)); // 10 20 30 40 50 60 70 80 90 100 110 120
    }

    // use queue
    private static List<List<Integer>> traverse(Node root) {
        var queue = new LinkedList<Node>();
        queue.offer(root);
        queue.offer(null);
        var finalList = new ArrayList<List<Integer>>();
        var list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node != null) {
                list.add(node.getData());
                for (var child : node.getChildren()){
                    queue.offer(child);
                }
            } else {
                finalList.add(list);
                if (!queue.isEmpty()){
                    list = new ArrayList<>();
                    queue.offer(null);
                }
            }

        }
        return finalList;
    }
}
