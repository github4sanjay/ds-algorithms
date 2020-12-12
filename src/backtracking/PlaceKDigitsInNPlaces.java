package backtracking;

import java.util.Arrays;

public class PlaceKDigitsInNPlaces {

    public static void main(String[] args) {
        // n = places, k = 1,2,3
        PlaceKDigitsInNPlaces.place(5, 3);
    }

    private static void place(int n, int k) {

        place(n, k, new int[n], 0, 0);
    }

    private static void place(int n, int k, int[] placed, int currentItem, int placeSoFar) {

        if (currentItem == n){
            if (k == placeSoFar){
                System.out.println(Arrays.toString(placed));

            }
            return;
        }


        for (int i=0; i< n; i++){
            if (placed[i] == 0){
                placed[i] = placeSoFar+1;
                place(n, k, placed, currentItem+1, placeSoFar+1);
                placed[i] = 0;
            }
        }
        place(n, k, placed, currentItem+1, placeSoFar);
    }
}
