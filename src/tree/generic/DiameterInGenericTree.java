package tree.generic;

import tree.generic.structure.GenericTreeUtil;
import tree.generic.structure.Node;

public class DiameterInGenericTree {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1};
        var root = GenericTreeUtil.createTree(arr);
        System.out.println(DiameterInGenericTree.find(root));
    }

    private static Answer find(Node root) {
        var answer = new Answer(Integer.MIN_VALUE);
        find(root, answer);
        return answer;
    }

    private static int find(Node root, Answer answer) {

        int height = -1;

        int firstMaxHeight = 0;
        int secondMaxHeight = 0;
        for (var child : root.getChildren()){
            height = Math.max(height, find(child, answer));
            if (height > firstMaxHeight){
                firstMaxHeight = height;
                secondMaxHeight = firstMaxHeight;
            } else if (height > secondMaxHeight){
                secondMaxHeight = height;
            }
        }
        answer.maxDiameter = Math.max(answer.maxDiameter, firstMaxHeight + secondMaxHeight + 2);
        return height + 1;
    }

    /**
     * Check this at every node
     * maxDiameter = height of first longest + second longest child + 2
     * O(n^2)
     */
    private static void findNotEfficient(Node root, Answer answer) {

        int firstMaxHeight = 0;
        int secondMaxHeight = 0;
        for (var child : root.getChildren()){
            int height = HeightGenericTree.find(child);
            if (height > firstMaxHeight){
                firstMaxHeight = height;
                secondMaxHeight = firstMaxHeight;
            } else if (height > secondMaxHeight){
                secondMaxHeight = height;
            }
        }
        answer.maxDiameter = Math.max(answer.maxDiameter, firstMaxHeight + secondMaxHeight + 2);
    }

    private static class Answer {
        int maxDiameter;

        public Answer(int maxDiameter) {
            this.maxDiameter = maxDiameter;
        }

        @Override
        public String toString() {
            return "Answer{" +
                    "maxDiameter=" + maxDiameter +
                    '}';
        }
    }
}
