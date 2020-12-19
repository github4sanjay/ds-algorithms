package linkedlist;

import linkedlist.structure.LinkedList;

public class KthNodeFromEnd {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(40);

        System.out.println(linkedList.getFromEnd(0));
        System.out.println(linkedList.getFromEnd(1));
        System.out.println(linkedList.getFromEnd(2));
    }

}
