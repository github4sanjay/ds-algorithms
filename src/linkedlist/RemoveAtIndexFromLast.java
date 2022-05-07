package linkedlist;

import linkedlist.structure.LinkedList;

public class RemoveAtIndexFromLast {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        
        System.out.println(linkedList.removeAtIndexFromLast(1));
        linkedList.print();

        linkedList.addLast(30);
        System.out.println(linkedList.removeAtIndexFromLast(2));
        linkedList.print();

    }
}
