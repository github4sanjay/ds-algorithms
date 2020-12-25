package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TraversalBinaryTree {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
        System.out.println(TraversalBinaryTree.recursive(root));
    }

    public static Answer recursive(BinaryNode root) {
        var answer = new Answer();
        recursive(root, answer);
        return answer;
    }

    private static void recursive(BinaryNode root, Answer answer) {
        if (root == null) return ;
        answer.addPreorder(root.getData()); // pre

        recursive(root.getLeft(), answer);

        answer.addInorder(root.getData()); // in

        recursive(root.getRight(), answer);

        answer.addPostorder(root.getData()); // post
    }

    public static class Answer {
        List<Integer> preorder;
        List<Integer> inorder;
        List<Integer> postorder;

        public Answer() {
            this.preorder = new ArrayList<>();
            this.inorder = new ArrayList<>();
            this.postorder = new ArrayList<>();
        }

        public List<Integer> getPreorder() {
            return preorder;
        }

        public List<Integer> getInorder() {
            return inorder;
        }

        public List<Integer> getPostorder() {
            return postorder;
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
