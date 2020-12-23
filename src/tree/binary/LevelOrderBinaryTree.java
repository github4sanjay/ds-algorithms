package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;
import tree.generic.structure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBinaryTree {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
        System.out.println(LevelOrderBinaryTree.iterative(root));
        System.out.println(LevelOrderBinaryTree.iterativeWithoutMarker(root));
        System.out.println(LevelOrderBinaryTree.withTwoQueue(root));
    }

    // with one queue and null as marker
    private static List<List<Integer>> iterative(BinaryNode root) {
        var list = new ArrayList<List<Integer>>();
        var queue = new LinkedList<BinaryNode>();
        queue.offer(root);
        queue.offer(null);
        var tempList = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            var node = queue.poll();
            if (node != null){
                tempList.add(node.getData());
                if (node.getLeft() != null){
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null){
                    queue.offer(node.getRight());
                }
            } else {
                list.add(tempList);
                if (!queue.isEmpty()) {
                    tempList = new ArrayList<>();
                    queue.offer(null);
                }
            }
        }

        return list;
    }

    // without queue and size loop
    private static List<List<Integer>> iterativeWithoutMarker(BinaryNode root) {
        var list = new ArrayList<List<Integer>>();
        var queue = new LinkedList<BinaryNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            var tempList = new ArrayList<Integer>();
            for (int i = queue.size()-1; i>=0; i--){
                var node = queue.poll();
                tempList.add(node.getData());
                if (node.getLeft() != null){
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null){
                    queue.offer(node.getRight());
                }
            }
            list.add(tempList);
        }

        return list;
    }

    // with the help of two queue
    private static List<List<Integer>> withTwoQueue(BinaryNode root) {
        var queue = new LinkedList<BinaryNode>();
        var childQueue = new LinkedList<BinaryNode>();
        queue.offer(root);
        var finalList = new ArrayList<List<Integer>>();
        var list = new ArrayList<Integer>();
        while (!(queue.isEmpty() && childQueue.isEmpty())) {
            if (!queue.isEmpty()) {
                var node = queue.poll();
                list.add(node.getData());
                if (node.getLeft() != null){
                    childQueue.offer(node.getLeft());
                }
                if (node.getRight() != null){
                    childQueue.offer(node.getRight());
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
}
