package tree.generic;

import tree.generic.structure.GenericTree;
import tree.generic.structure.Node;

public class AreTreesMirrorInShape {

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        var root1 = GenericTree.createTree(arr1);

        int[] arr2 = new int[]{1, 2, 5, -1, 6, -1, -1, 3, 7, -1, 8, 11, -1, 12, -1, -1, 9, -1, -1, 4, 10, -1, -1, -1};
        var root2 = GenericTree.createTree(arr2);

        System.out.println(AreTreesMirrorInShape.check(root1, root2));


        var root3 = GenericTree.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        System.out.println(AreTreesMirrorInShape.check(root1, root3));

        var root4 = GenericTree.createTree(new int[] {100, 200, -1, 300, 500, -1, 600, -1, -1, 400, -1, -1});
        System.out.println(AreTreesMirrorInShape.check(root4, root3));
    }

    /**
     * Number of children of root1 first child and number of children of root2 last child should be equal
     * and same for other children at different positions
     */
    public static boolean check(Node root1, Node root2) {

        var children1 = root1.getChildren();
        var children2 = root2.getChildren();
        if (children1.size() != children2.size()){
            return false;
        }

        for (int i=0; i< children1.size(); i++){
            if (!check(children1.get(i), children2.get(children1.size()-i-1))){
                return false;
            }
        }
        return true;
    }
}
