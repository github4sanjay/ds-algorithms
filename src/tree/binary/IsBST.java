package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;

/**
 * You are required to check if the tree is a Binary Search Tree (BST) as well.
 * In a BST every node has a value greater than all nodes on it's left side and smaller value than all node on it's right side.
 */
public class IsBST {

    public static void main(String[] args) {
        int n = -1;
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, n, n, 37, n, n, 75, 62, n, n, 87, n, n});
        System.out.println(IsBST.recursive(root));

        var root1 = BinaryTreeUtil.create(new int[]{50, 25, 12, n, n, 37, 30, n, n, 51, n, n, 75, 62, 60, n, n, 70, n, n, n});
        System.out.println(IsBST.recursive(root1));
    }


    private static Answer recursive(BinaryNode root) {
        if (root == null) {
            var answer = new Answer();
            answer.isBST = true;
            answer.max = Integer.MIN_VALUE;
            answer.min = Integer.MAX_VALUE;
            return answer;
        }

        var leftAnswer = recursive(root.getLeft());
        var rightAnswer = recursive(root.getRight());

        var answer = new Answer();
        answer.isBST = leftAnswer.isBST && rightAnswer.isBST && root.getData() > leftAnswer.max && root.getData() < rightAnswer.min;
        answer.min = Math.min(root.getData(), Math.min(leftAnswer.min, rightAnswer.min));
        answer.max = Math.max(root.getData(), Math.max(leftAnswer.max, rightAnswer.max));
        return answer;
    }

    private static class Answer {
        int max;
        int min;
        boolean isBST;

        @Override
        public String toString() {
            return "Answer{" +
                    "max=" + max +
                    ", min=" + min +
                    ", isBST=" + isBST +
                    '}';
        }
    }
}
