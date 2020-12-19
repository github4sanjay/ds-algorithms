package linkedlist;

import linkedlist.structure.LinkedList;

public class GetFirst {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);

        System.out.println(linkedList.getFirst()); //10
    }
}
