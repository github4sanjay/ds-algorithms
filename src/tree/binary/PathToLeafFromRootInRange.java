package tree.binary;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;
import util.AlgoUtil;

import java.util.ArrayList;
import java.util.List;

public class PathToLeafFromRootInRange {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, 30, -1, -1, 40, -1, -1, 75, 62, 60, -1, -1, 70, -1, -1, 87, -1, -1});
        AlgoUtil.print(PathToLeafFromRootInRange.recursive(root, 150, 250));
    }

    private static List<List<Integer>> recursive(BinaryNode root, int sumLow, int sumHigh) {
        var list = new ArrayList<List<Integer>>();
        recursive(root, sumLow, sumHigh, 0, new ArrayList<>(), list);
        return list;
    }

    /**
     * add node to current path and node data to sum
     * check if its leaves and sum is in range
     * if yes add to the final list
     *
     * check in left child
     * check in right child
     *
     * at last remove node from current path
     *
     */
    private static void recursive(BinaryNode root, int sumLow, int sumHigh, int sum, List<Integer> currentPath, List<List<Integer>> totalPaths) {
        if (root == null) return;

        sum = sum + root.getData();
        currentPath.add(root.getData());
        if (root.getLeft() == null && root.getRight() == null){
            if (sum > sumLow && sum < sumHigh){
                totalPaths.add(new ArrayList<>(currentPath));
            }
        }

        if (root.getLeft() != null){
            recursive(root.getLeft(), sumLow, sumHigh, sum, currentPath, totalPaths);
        }

        if (root.getRight() != null){
            recursive(root.getRight(), sumLow, sumHigh, sum, currentPath, totalPaths);
        }

        currentPath.remove(currentPath.size()-1);
    }
}
