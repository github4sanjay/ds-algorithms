package linkedlist;

import linkedlist.structure.LinkedList;

public class RemoveAtIndex {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        
        System.out.println(linkedList.removeAtIndex(1));
        linkedList.print();

        linkedList.addLast(30);
        System.out.println(linkedList.removeAtIndex(2));
        linkedList.print();

    }

}
