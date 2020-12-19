package linkedlist;

import linkedlist.structure.LinkedList;
import linkedlist.structure.LinkedListUtil;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(34);

        LinkedList<Integer> anotherLL = new LinkedList<>();
        anotherLL.addLast(1);
        anotherLL.addLast(2);
        anotherLL.addLast(3);
        LinkedListUtil.mergeSorted(linkedList.getHead(), anotherLL.getHead()).print();
    }


}
