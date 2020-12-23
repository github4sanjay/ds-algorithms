package tree.generic;

import tree.generic.structure.GenericTreeUtil;
import tree.generic.structure.Node;

public class AreTreesSimilarInShape {

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        var root1 = GenericTreeUtil.createTree(arr1);

        int[] arr2 = new int[]{1, 2, 5, -1, 6, -1, -1, 3, 7, -1, 8, 11, -1, 12, -1, -1, 9, -1, -1, 4, 10, -1, -1, -1};
        var root2 = GenericTreeUtil.createTree(arr2);

        System.out.println(AreTreesSimilarInShape.check(root1, root2));


        var root3 = GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(AreTreesSimilarInShape.check(root1, root3));
    }

    /**
     * root1 and root2 should have same number of children and all children at same position should
     * have same number of children
     */
    private static boolean check(Node root1, Node root2) {

        var children1 = root1.getChildren();
        var children2 = root2.getChildren();
        if (children1.size() != children2.size()){
            return false;
        }

        for (int i=0; i< children1.size(); i++){
            if (!check(children1.get(i), children2.get(i))){
                return false;
            }
        }
        return true;
    }
}
