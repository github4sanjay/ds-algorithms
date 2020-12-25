package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversalBinaryTree {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
        System.out.println(IterativeTraversalBinaryTree.recursive(root));
        System.out.println(TraversalBinaryTree.recursive(root));
    }

    public static BinaryNode getNextFromNormalInOrder(Stack<Pair> inOrderStack) {

        while (!inOrderStack.isEmpty()){
            var peek = inOrderStack.peek();
            if (peek.state == 0){
                var node = peek.node;
                if (node.getLeft() != null){
                    inOrderStack.push(new Pair(node.getLeft(), 0));
                }
                peek.state++;
            } else if (peek.state == 1){
                var node = peek.node;
                if (node.getRight() != null){
                    inOrderStack.push(new Pair(node.getRight(), 0));
                }
                peek.state++;
                return node;
            } else {
                inOrderStack.pop();
            }
        }

        return null;
    }

    public static BinaryNode getNextFromReverseInOrder(Stack<Pair> inOrderStack) {

        while (!inOrderStack.isEmpty()){
            var peek = inOrderStack.peek();
            if (peek.state == 0){
                var node = peek.node;
                if (node.getRight() != null){
                    inOrderStack.push(new Pair(node.getRight(), 0));
                }
                peek.state++;
            } else if (peek.state == 1){
                var node = peek.node;
                if (node.getLeft() != null){
                    inOrderStack.push(new Pair(node.getLeft(), 0));
                }
                peek.state++;
                return node;
            } else {
                inOrderStack.pop();
            }
        }

        return null;
    }


    private static Answer recursive(BinaryNode root) {
        var answer = new Answer();
        var stack = new Stack<Pair>();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()){
            var pair = stack.peek();
            var node = pair.node;
            if (pair.state == 0){
                answer.addPreorder(pair.node.getData());
                if (node.getLeft() != null){
                    stack.push(new Pair(node.getLeft(), 0));
                }
                pair.state++;
            } else if (pair.state == 1){
                answer.addInorder(pair.node.getData());
                if (node.getRight() != null){
                    stack.push(new Pair(node.getRight(), 0));
                }
                pair.state++;
            } else {
                answer.addPostorder(pair.node.getData());
                stack.pop();
            }
        }
        return answer;
    }

    public static class Pair {
        BinaryNode node;
        int state;

        public Pair(BinaryNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private static class Answer {
        List<Integer> preorder;
        List<Integer> inorder;
        List<Integer> postorder;

        public Answer() {
            this.preorder = new ArrayList<>();
            this.inorder = new ArrayList<>();
            this.postorder = new ArrayList<>();
        }

        public void addPreorder(int data){
            preorder.add(data);
        }

        public void addPostorder(int data){
            postorder.add(data);
        }

        public void addInorder(int data){
            inorder.add(data);
        }

        @Override
        public String toString() {
            return "Answer{" +
                    "preorder=" + preorder +
                    ", inorder=" + inorder +
                    ", postorder=" + postorder +
                    '}';
        }
    }
}
