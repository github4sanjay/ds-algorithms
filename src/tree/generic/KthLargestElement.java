package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.Node;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100, -1, -1, -1};
        var root = GenericTree.createTree(arr);
        System.out.println(KthLargestElement.find(root, 8));
    }

    /**
     *
     * floor of Integer.MAX_VALUE will be first largest value
     *
     */
    private static int find(Node root, int k) {
        var floor = Integer.MAX_VALUE;
        for (int i=0; i < k; i++) {
            var answer = CeilAndFloor.iterative(root, floor);
            floor = answer.floor;
        }
        return floor;
    }
}
