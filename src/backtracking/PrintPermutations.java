package backtracking;

/**
 * npr - > n!/(n-r)!
 */
public class PrintPermutations {

    public static void main(String[] args) {
        /**
         * 120
         * 102
         * 210
         * 012
         * 201
         * 021
         */
        int nBoxes = 3;
        int totalItems = 2; // one of each item {1,2}
        // PrintPermutations.print(new int[nBoxes], totalItems, 1);

        /**
         * 1200
         * 1020
         * 1002
         * 2100
         * 0120
         * 0102
         * 2010
         * 0210
         * 0012
         * 2001
         * 0201
         * 0021
         */
        // PrintPermutations.print(new int[4], totalItems, 1);


        print(2, 3, 0, 1, "", new boolean[3]);

    }

    private static void print(int[] boxes, int totalItems, int currentItem) {
        if (currentItem > totalItems){
            for (int i=0; i< boxes.length; i++){
                System.out.print(boxes[i]);
            }
            System.out.println("");
            return;
        }
        for (int i=0; i< boxes.length; i++){
            if (boxes[i] == 0){
                boxes[i] = currentItem;
                print(boxes, totalItems, currentItem+1);
                boxes[i] = 0;
            }
        }
    }

    // with combination trick (box decides whom to place choices are no one, 1 or 2)
    public static void print(int totalItems, int totalBox, int noOfSelected, int currentBox, String ans, boolean[] items){
        if (currentBox > totalBox){
            if (noOfSelected == totalItems){
                System.out.println(ans);
            }
            return;
        }


        for (int i=0;i < totalItems; i++){
            if (!items[i]){
                items[i] = true;
                print(totalItems, totalBox, noOfSelected + 1, currentBox+1, ans+(i+1), items);
                items[i] = false;
            }
        }
        print(totalItems, totalBox, noOfSelected, currentBox+1, ans+ 0, items);
    }

}
