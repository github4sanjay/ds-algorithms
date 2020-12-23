package tree.binary;

import tree.binary.structure.BinaryTreeUtil;
import util.AlgoUtil;

public class CreateBinaryTree {

    public static void main(String[] args) {
        var root = BinaryTreeUtil.create(new int[]{50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
        AlgoUtil.print(BinaryTreeUtil.display(root));
    }
}
