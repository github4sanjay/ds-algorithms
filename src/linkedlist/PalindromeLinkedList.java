package linkedlist;

import linkedlist.structure.LinkNode;
import linkedlist.structure.LinkedList;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(30);
        linkedList.addLast(20);
        linkedList.addLast(10);

        System.out.println(isPalindrome(linkedList.getHead()));
        linkedList.print();

        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.addLast(10);
        linkedList1.addLast(20);
        linkedList1.addLast(30);
        linkedList1.addLast(40);
        linkedList1.addLast(30);
        linkedList1.addLast(20);
        linkedList1.addLast(70);

        System.out.println(isPalindrome(linkedList1.getHead()));
        linkedList1.print();
    }

    public static boolean isPalindrome(LinkNode<Integer> head) {
        if (head == null || head.getNext() == null) return true;
        var mid = getMid(head);
        var headLastHalf = mid.getNext();
        mid.setNext(null);
        headLastHalf = reverse(headLastHalf);

        var currentFirstHalf = head;
        var currentSecondHalf = headLastHalf;
        var res = true;
        while (currentSecondHalf != null) {
            if (!currentFirstHalf.getData().equals(currentSecondHalf.getData())){
                res = false;
                break;
            }
            currentFirstHalf = currentFirstHalf.getNext();
            currentSecondHalf = currentSecondHalf.getNext();
        }
        mid.setNext(reverse(headLastHalf));
        return res;
    }

    private static LinkNode<Integer> getMid(LinkNode<Integer> head) {
        if (head == null || head.getNext() == null) return head;
        var slow = head;
        var fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private static LinkNode<Integer> reverse(LinkNode<Integer> head) {
        if (head == null || head.getNext() == null) return head;
        LinkNode<Integer> prev = null;
        var current = head;
        while (current != null) {
            var forward = current.getNext();
            current.setNext(prev);
            prev = current;
            current = forward;
        }
        return prev;
    }

    private static void print(LinkNode<Integer> head) {
        var current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
