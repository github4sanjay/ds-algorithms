package linkedlist;

import linkedlist.structure.LinkNode;
import linkedlist.structure.LinkedList;

/**
 * Rearrange a given linked list in-place.
 * Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln. Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …
 * You are required to do this in-place without altering the nodes’ values.
 * Examples:
 *
 * Input:  1 -> 2 -> 3 -> 4
 * Output: 1 -> 4 -> 2 -> 3
 *
 * Input:  1 -> 2 -> 3 -> 4 -> 5
 * Output: 1 -> 5 -> 2 -> 4 -> 3
 */
public class FoldLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.addLast(7);
        linkedList.addLast(8);

        FoldLinkedList.fold(linkedList);

        linkedList.print();
    }

    /**
     * Find mid node by slow and fast pointer
     * Add all the nodes after middle node to stack
     * Remove elements from stack one by one and append in linked list
     * and also remove last element from linked list as its already used from stack
     */
    private static void fold(LinkedList<Integer> linkedList) {
        var faster = linkedList.getHead();
        var slower = linkedList.getHead();
        var stack = new LinkedList<Integer>();
        while(faster.getNext() != null && faster.getNext().getNext() != null){
            slower = slower.getNext();
            faster = faster.getNext().getNext();
        }
        slower = slower.getNext();
        while (slower != null){
            stack.addFirst(slower.getData());
            slower = slower.getNext();
        }

        var currentNode = linkedList.getHead();
        while (stack.getSize() != 0){
            var node = stack.removeFirst();
            var next = currentNode.getNext();
            currentNode.setNext(new LinkNode<>(node, next));
            currentNode = next;
            linkedList.removeLast();
        }
    }
}
