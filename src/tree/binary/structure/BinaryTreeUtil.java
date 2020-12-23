package tree.binary.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeUtil {

    public static BinaryNode create(int[] ints) {
        var stack = new Stack<Pair>();
        var head = new BinaryNode(ints[0], null, null);
        stack.push(new Pair(head, 0));
        int i = 1;
        while (!stack.isEmpty()){
            var pair = stack.peek();
            if (pair.state == 0) {
                if (ints[i] != -1) {
                    var newNode = new BinaryNode(ints[i], null, null);
                    pair.data.setLeft(newNode);
                    stack.push(new Pair(newNode, 0));
                }
                pair.state++;
                i++;
            } else if (pair.state == 1){
                if (ints[i] != -1) {
                    var newNode = new BinaryNode(ints[i], null, null);
                    pair.data.setRight(newNode);
                    stack.push(new Pair(newNode, 0));
                }
                pair.state++;
                i++;
            } else {
                stack.pop();
            }

        }
        return head;
    }

    private static class Pair {
        BinaryNode data;
        int state;

        public Pair( BinaryNode data, int state) {
            this.data = data;
            this.state = state;
        }
    }

    public static List<Display> display(BinaryNode root) {
        var list = new ArrayList<Display>();
        display(root, list);
        return list;
    }

    public static void display(BinaryNode root, List<Display> list) {
        if (root ==  null){
            return;
        }
        list.add(new Display(root.getLeft() != null ? root.getLeft().getData() : -1, root.getData(), root.getRight() != null ? root.getRight().getData() : -1));
        display(root.getLeft(), list);
        display(root.getRight(), list);
    }

    public static class Display {
        int left;
        int root;
        int right;

        public Display(int left, int root, int right) {
            this.left = left;
            this.root = root;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Display{" +
                    "left=" + left +
                    ", root=" + root +
                    ", right=" + right +
                    '}';
        }
    }
}
