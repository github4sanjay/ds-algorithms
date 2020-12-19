package linkedlist;

import linkedlist.structure.LinkedList;

/**
 * Function to check if a singly linked list is palindrome
 *
 * Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.
 */
public class IsLinkedListPalindrome {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        System.out.println(IsLinkedListPalindrome.find(linkedList));
    }

    /**
     * Find mid node by slow and fast pointer
     * Add all the nodes after middle node to stack
     * Remove elements from stack one by one and check in the linked list current node
     * if equal increase current node to next node of linked list
     * if not equal return false
     * once stack is empty
     *  1. check if slow pointer is same as current node ( for case when odd number of elements)
     *  2. check if slow pointer next is same as current node ( for case when even number of elements)
     */
    private static boolean find(LinkedList<Integer> linkedList) {
        var slower = linkedList.getHead();
        var faster = linkedList.getHead();

        while (faster.getNext() != null && faster.getNext().getNext() != null){
            slower = slower.getNext();
            faster = faster.getNext().getNext();
        }

        var startOfRightPart = slower.getNext();
        var stack = new LinkedList<Integer>();
        while (startOfRightPart != null){
            stack.addFirst(startOfRightPart.getData());
            startOfRightPart = startOfRightPart.getNext();
        }

        var currentNode = linkedList.getHead();
        while (stack.getSize() != 0){
            var node = stack.removeFirst();
            if (!currentNode.getData().equals(node)){
                return false;
            }
            currentNode = currentNode.getNext();
        }

        if (slower.getNext() == currentNode || slower == currentNode){
            return true;
        } else {
            return false;
        }

    }

}
