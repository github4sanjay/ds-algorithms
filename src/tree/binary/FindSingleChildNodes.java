package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;
import util.AlgoUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindSingleChildNodes {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
        System.out.println(FindSingleChildNodes.recursive(root));
        System.out.println(FindSingleChildNodes.iterative(root));
    }

    private static List<Integer> iterative(BinaryNode root) {
        var list = new ArrayList<Integer>();
        var queue = new LinkedList<BinaryNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            var node = queue.poll();
            if (node.getLeft() == null && node.getRight() != null){
                list.add(node.getData());
            } else if (node.getLeft() != null && node.getRight() == null){
                list.add(node.getData());
            }

            if (node.getLeft() != null){
                queue.offer(node.getLeft());
            }

            if (node.getRight() != null){
                queue.offer(node.getRight());
            }
        }
        return list;
    }

    private static List<Integer> recursive(BinaryNode root) {
        var list = new ArrayList<Integer>();
        recursive(root, list);
        return list;
    }

    private static void recursive(BinaryNode root, List<Integer> list) {
        if (root == null) return;

        if (root.getLeft() == null && root.getRight() != null){
            list.add(root.getData());
        } else if (root.getLeft() != null && root.getRight() == null){
            list.add(root.getData());
        }

        if (root.getLeft() != null){
            recursive(root.getLeft(), list);
        }

        if (root.getRight() != null){
            recursive(root.getRight(), list);
        }
    }
}
