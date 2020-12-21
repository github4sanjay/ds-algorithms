package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NodeToRootPathGenericTree {

    public static void main(String[] args) {
        var root = GenericTree.createTree(new int[] {10 , 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1});
        // System.out.println(NodeToRootPathGenericTree.iterative(root, 120));
        System.out.println(NodeToRootPathGenericTree.recursion(root, 120));

    }

    private static List<Integer> recursion(Node root, int find) {
        if (root.getData() == find){
            var path = new ArrayList<Integer>();
            path.add(root.getData());
            return path;
        }
        for (var child : root.getChildren()){
            var path = recursion(child, find);
            if (!path.isEmpty()){
                path.add(root.getData());
                return path;
            }
        }
        return new ArrayList<>();
    }
}
