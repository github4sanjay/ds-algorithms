package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.GenericTreeUtil;
import tree.generic.structure.Node;

import java.util.ArrayList;
import java.util.List;

public class IterableInGenericTree {

    public static void main(String[] args) {
        var root = GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(IterableInGenericTree.iterate(root));
    }

    private static List<Integer> iterate(Node root) {
        var list = new ArrayList<Integer>();
        var genericTree = new GenericTree(root);
        for (Integer integer : genericTree) {
            list.add(integer);
        }
        return list;
    }
}
