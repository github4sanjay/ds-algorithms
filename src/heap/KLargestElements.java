package heap;

import java.util.PriorityQueue;

public class KLargestElements {

    public void findKLargestElements(int [] A, int k){
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
        while (queue.size() > 0){
            System.out.println(queue.remove());
        }
    }
}
