package linkedlist;

import linkedlist.structure.LinkedList;
import linkedlist.structure.LinkedListUtil;

public class MergeSort {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(20);
        linkedList.addLast(10);
        linkedList.addLast(30);
        linkedList.addLast(5);
        linkedList.addLast(3);
        linkedList.addLast(34);
        linkedList.addLast(1);

        LinkedListUtil.mergeSort(linkedList).print();
    }

}
