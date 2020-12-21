package tree.generic.structure;

import java.util.*;

public class GenericTree {

    public static HashMap<Integer, List<Integer>> display(Node root) {
        var queue = new LinkedList<Node>();
        queue.push(root);
        var map = new HashMap<Integer, List<Integer>>();
        while (!queue.isEmpty()){
            var node = queue.pop();
            var list = new ArrayList<Integer>();
            for (var child : node.getChildren()){
                queue.push(child);
                list.add(child.getData());
            }
            map.put(node.getData(), list);
        }
        return map;
    }

    public static HashMap<Integer, List<Integer>> displayRecursion(Node root) {
        var map = new HashMap<Integer, List<Integer>>();
        displayRecursion(root, map);
        return map;
    }

    private static void displayRecursion(Node root, HashMap<Integer, List<Integer>> map) {
        var list = new ArrayList<Integer>();
        for (var child : root.getChildren()){
            list.add(child.getData());
        }
        map.put(root.getData(), list);

        for (var child : root.getChildren()){
            displayRecursion(child, map);
        }
    }

    public static Node createTree(int[] arr) {
        var stack = new Stack<Node>();
        Node root = null;
        for (int j : arr) {
            if (j == -1) {
                stack.pop();
            } else {
                var node = new Node();
                node.setData(j);

                if (stack.isEmpty()) {
                    root = node;
                } else {
                    var peekNode = stack.peek();
                    peekNode.addChildren(node);
                }
                stack.push(node);
            }
        }

        return root;
    }
}
