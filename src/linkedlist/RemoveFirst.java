package linkedlist;

import linkedlist.structure.LinkedList;

public class RemoveFirst {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);

        System.out.println(linkedList.removeFirst()); // 10
        System.out.println(linkedList.removeFirst()); // 20
    }
}
