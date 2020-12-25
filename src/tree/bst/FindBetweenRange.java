package tree.bst;

import tree.binary.structure.BinaryNode;
import tree.binary.structure.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.List;

public class FindBetweenRange {

    public static void main(String[] args) {
        int n = -1;
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, n, n, 37, 30, n, n, n, 75, 62, 60, n, n, 70, n, n, 87, n, n});
        System.out.println(FindBetweenRange.find(root, 12, 65)); // 25
    }

    private static List<Integer> find(BinaryNode root, int low, int high) {
        var list = new ArrayList<Integer>();
        find(root, low, high, list);
        return list;
    }

    private static void find(BinaryNode root, int low, int high, List<Integer> list) {
        if (root == null) return;

        if (high < root.getData()){ // data is greater than range so go left
            find(root.getLeft(), low, high, list);
        }else if (low > root.getData()){ // data is smaller than range so go right
            find(root.getRight(), low, high, list);
        } else {
            find(root.getLeft(), low, high, list);
            list.add(root.getData());
            find(root.getRight(), low, high, list);
        }
    }
}
