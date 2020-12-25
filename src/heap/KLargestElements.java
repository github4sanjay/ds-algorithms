package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElements {

    public static void main(String[] args) {
       System.out.println(KLargestElements.findKLargestElements(new int[]{ 11, 3, 2, 1, 15, 5, 4,
               45, 88, 96, 50, 45 }, 3));
    }

    public static List<Integer> findKLargestElements(int[] A, int k){
        var queue = new PriorityQueue<Integer>();
        for (int i=0; i< A.length;i++){
            if (i< k){
                queue.add(A[i]);
            }else {
                if (queue.peek() < A[i]){
                    queue.remove();
                    queue.add(A[i]);
                }
            }
        }
        var list = new ArrayList<Integer>();
        while (queue.size() > 0){
            list.add(queue.remove());
        }
        return list;
    }
}
