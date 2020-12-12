package backtracking;

/**
 * ncr - > n!/(n-r)!*r!
 * 2^4 -> 4c0+4c1+4c2+4c3+4c4
 */
public class PrintCombinations {

    public static void main(String[] args) {
        print(2, 3, 0, 0, "");
        // print(new int[3], 2, 1, -1);
    }

    // without array
    public static void print(int totalItems, int totalBox, int noOfSelected, int currentBox, String ans){
        if (currentBox > totalBox){
            if (noOfSelected == totalItems){
                System.out.println(ans);
            }
            return;
        }

        print(totalItems, totalBox, noOfSelected, currentBox+1, ans+"0");
        print(totalItems, totalBox, noOfSelected+1, currentBox+1, ans+"1");
    }

    // like permutation trick
    private static void print(int[] boxes, int totalItems, int currentItem, int lastBox) {
        if (currentItem > totalItems){
            for (int i=0; i< boxes.length; i++){
                System.out.print(boxes[i]);
            }
            System.out.println("");
            return;
        }

        // next box after last
        for (int i= lastBox+1; i< boxes.length; i++){
            if (boxes[i] == 0){
                boxes[i] = 1;
                print(boxes, totalItems, currentItem+1, i);
                boxes[i] = 0;
            }
        }
    }
}
