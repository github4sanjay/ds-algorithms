package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortNearlySortedArray {
    public void sortNearlySortedArray(int [] A, int k){
        var queue = new PriorityQueue<Integer>();
        for (int i=0; i<= k;i++){
            queue.add(A[i]);
        }
        for (int i=k+1; i< A.length; i++){
            if (queue.peek() < A[i]){
                System.out.println(queue.remove());
                queue.add(A[i]);
            }
        }
        while (queue.size() > 0){
            System.out.println(queue.remove());
        }
    }

    public static void main(String[] args) {
        var sortNearlySortedArray = new SortNearlySortedArray();
        sortNearlySortedArray.sortNearlySortedArray(new int[]{2, 3, 1, 4, 6, 7, 5, 8, 9}, 2);
    }
}
