package heap;

import java.util.Arrays;

public class Heap {
    private int[] array;
    private int capacity;
    private int count;
    private final int heapType;

    public Heap(int capacity, int heapType) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
        this.heapType = heapType;
    }

    public int parent(int i){
        if (i<= 0 || i > count){
            return -1;
        }
        return (i-1)/2;
    }

    public int leftChild(int i){
        int left = 2*i+1;
        if (left >= this.count) return -1;
        return left;
    }

    public int rightChild(int i){
        int right = 2*i+2;
        if (right >= this.count) return -1;
        return right;
    }

    public int getMax(){
        if (this.count == 0){
            return -1;
        }
        return array[0];
    }

    public void percolateDown(int k){
        int l = leftChild(k);
        int r = rightChild(k);
        int max;
        if (l != -1 && array[l] > array[k]) max = l;
        else max = k;

        if (r != -1 && array[r] > array[max]) max = r;
        if (max != k){
            int temp = array[k];
            array[k] = array[max];
            array[max] = temp;
            percolateDown(max);
        }
    }

    public int deleteMax(){
        if (count == 0){
            return -1;
        }
        int data = array[0];
        array[0] = array[count-1];
        count--;
        percolateDown(0);
        return data;
    }

    public void insert(int data){
        if (count == capacity){
            resize();
        }
        count++;
        int i = count - 1;
        while (i >0 && data > array[(i-1)/2]){
            array[i] = array[(i-1)/2];
            i = (i-1)/2;
        }
        array[i] = data;
    }

    public int getCapacity() {
        return capacity;
    }

    private void resize() {
        int[] newArray = new int[2*capacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        this.capacity = 2*capacity;
        this.array = newArray;
    }

    public static void buildHeap(Heap h, int[] A){
        while (h.getCapacity() < A.length){
            h.resize();
        }
        h.count = A.length;
        System.arraycopy(A, 0, h.array, 0, A.length);
        for (int i = (h.count-1)/2; i>=0; i--){
            h.percolateDown(i);
        }
    }

    public static int[] HeapSort(int[] A){
        Heap heap = new Heap(A.length, 1);
        Heap.buildHeap(heap, A);
        for (int i =0; i< A.length;i++){
            int temp = heap.getMax();
            heap.array[0] = heap.array[heap.count - 1];
            heap.array[heap.count - 1] = temp;
            heap.count--;
            heap.percolateDown(0);
        }
        return heap.array;
    }

    public static void main(String[] args) {

        Heap heap2 = new Heap(2, 1);
        Heap.buildHeap(heap2, new int[]{2,5,1,9,4,3});
        System.out.println(heap2.getMax());
        System.out.println(Arrays.toString(HeapSort(new int[]{2,5,1,9,4,3})));
    }
}
