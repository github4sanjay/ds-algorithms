package tree.generic;

import tree.generic.structure.GenericTreeUtil;
import tree.generic.structure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderLineWiseGenericTree {

    public static void main(String[] args) {
        var root = GenericTreeUtil.createTree(new int[] {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1});
        System.out.println(LevelOrderLineWiseGenericTree.traverse(root));
        System.out.println(LevelOrderLineWiseGenericTree.traverseSecondWay(root));
        System.out.println(LevelOrderLineWiseGenericTree.traverseThirdWay(root));
    }

    // use queue and null as marker of level
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

    // with the help of two queue
    private static List<List<Integer>> traverseSecondWay(Node root) {
        var queue = new LinkedList<Node>();
        var childQueue = new LinkedList<Node>();
        queue.offer(root);
        var finalList = new ArrayList<List<Integer>>();
        var list = new ArrayList<Integer>();
        while (!(queue.isEmpty() && childQueue.isEmpty())) {
            if (!queue.isEmpty()) {
                var node = queue.poll();
                list.add(node.getData());
                for (var child : node.getChildren()){
                    childQueue.offer(child);
                }
            } else {
                finalList.add(list);
                list = new ArrayList<>();
                while (!childQueue.isEmpty()){
                    queue.offer(childQueue.poll());
                }
            }

        }
        finalList.add(list);
        return finalList;
    }


    private static List<List<Integer>> traverseThirdWay(Node root) {
        var queue = new LinkedList<Node>();
        queue.offer(root);
        var finalList = new ArrayList<List<Integer>>();
        var list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i=0; i< size; i++){
                var node = queue.poll();
                list.add(node.getData());
                for (var child : node.getChildren()){
                    queue.offer(child);
                }
            }
            finalList.add(list);
            list = new ArrayList<>();
        }
        return finalList;
    }
}
