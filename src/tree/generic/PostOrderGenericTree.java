package tree.generic;

import tree.generic.structure.GenericTreeUtil;
import tree.generic.structure.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderGenericTree {

    public static void main(String[] args) {
        var root = GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(PostOrderGenericTree.traverse(root));
        System.out.println(PostOrderGenericTree.traverseRecursion(root));
    }

    // with help of two stacks
    private static List<Integer> traverse(Node root) {
        var stack1 = new Stack<Node>();
        var stack2 = new Stack<Node>();
        stack1.push(root);
        var list = new ArrayList<Integer>();
        while (!stack1.isEmpty()) {
            var node = stack1.pop();
            stack2.push(node);
            for (var child : node.getChildren()){
                stack1.push(child);
            }
        }
        while (!stack2.isEmpty()){
            var node = stack2.pop();
            list.add(node.getData());
        }
        return list;
    }

    private static List<Integer> traverseRecursion(Node root) {
        var list = new ArrayList<Integer>();
        traverseRecursion(root, list);
        return list;
    }
    private static void traverseRecursion(Node root, List<Integer> list) {
        for (var child : root.getChildren()){
            traverseRecursion(child, list);
        }
        list.add(root.getData());
    }
}
