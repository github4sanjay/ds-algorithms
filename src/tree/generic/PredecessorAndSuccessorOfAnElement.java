package tree.generic;

import tree.generic.structure.GenericTreeUtil;
import tree.generic.structure.Node;

import java.util.Stack;

// this is in preorder
public class PredecessorAndSuccessorOfAnElement {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100, -1, -1, -1};
        var root = GenericTreeUtil.createTree(arr);
        System.out.println(PredecessorAndSuccessorOfAnElement.iterative(root, -120));
        System.out.println(PredecessorAndSuccessorOfAnElement.recursive(root, -120));
    }

    private static Answer recursive(Node root, int data) {
        Answer answer = new Answer();
        state = 0;
        recursive(root, data, answer);
        return answer;
    }

    private static Integer state; // need this in heap so that it does not change in recursion
    private static void recursive(Node root, int data, Answer answer) {
        if (state == 0){
            if (root.getData() == data){
                state = 1;
            } else {
                answer.predecessor = root.getData();
            }
        } else if (state == 1){
            answer.successor = root.getData();
            state = 2;
        }
        for (var child : root.getChildren()){
            recursive(child, data, answer);
        }
    }

    private static Answer iterative(Node root, int data) {
        var stack = new Stack<Node>();
        stack.push(root);
        Node pre = null;
        Node suc = null;
        while (!stack.isEmpty()) {
            var node = stack.pop();
            var children = node.getChildren();
            for (int i = children.size()-1; i>=0; i--){
                var child = children.get(i);
                stack.push(child);
            }
            if (node.getData() == data){
                suc = stack.pop();
                break;
            } else {
                pre = node;
            }
        }
        return new Answer(pre.getData(), suc.getData());
    }

    public static class Answer {
        int predecessor;
        int successor;

        public Answer() {
        }

        public Answer(int predecessor, int successor) {
            this.predecessor = predecessor;
            this.successor = successor;
        }

        @Override
        public String toString() {
            return "Answer{" +
                    "predecessor=" + predecessor +
                    ", successor=" + successor +
                    '}';
        }
    }
}
