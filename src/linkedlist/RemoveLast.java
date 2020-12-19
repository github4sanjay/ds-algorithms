package linkedlist;

import linkedlist.structure.LinkedList;

public class RemoveLast {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);

        System.out.println(linkedList.removeLast());
        linkedList.print();

        System.out.println(linkedList.removeLast());
        linkedList.print();

    }

}
