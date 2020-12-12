package linkedlist;

import java.util.HashMap;

public class LinkedList<T> {
    private LinkNode<T> head;

    public static <T> LinkNode<T> reverse(LinkNode<T> head){
        if (head == null) return head;
        var current = head;
        LinkNode<T> prev = null;
        while (current != null){
            var next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    public static <T> LinkNode<T> reversePair(LinkNode<T> head){
        if (head == null) return head;
        var current = head;
        LinkNode<T> prev = null;
        while (current != null && current.getNext() != null){
            var next = current.getNext();
            var temp = next.getNext();
            current.setNext(temp);
            next.setNext(current);
            if (prev == null){
                head = next;
            } else {
                prev.setNext(next);
            }
            prev = current;
            current = temp;
        }
        return head;
    }

    public static <T> LinkNode<T> reverseBlockOfNodes(LinkNode<T> head, int k){
        if (head == null) return head;
        var current = head;
        var prevCurrent = head;
        LinkNode<T> prevTail = null;
        while (current != null){
            LinkNode<T> prev = null;
            int count = k;
            while (current != null && count > 0){
                var next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
                count--;
            }
            if (prevTail == null){
                head = prev;
            } else {
                prevTail.setNext(prev);
            }
            prevTail = prevCurrent;
            prevCurrent = current;
        }
        return head;
    }

    public void addAtLast(T data){
        if (head == null){
            head = new LinkNode<>(data, null);
        } else {
            var curr = head;
          while (curr.getNext() != null){
              curr = curr.getNext();
          }
          curr.setNext(new LinkNode<>(data, null));
        }
    }

    public static <T> void print(LinkNode<T> head){
        if (head != null) {
            var curr = head;
            while (curr.getNext() != null) {
                System.out.print(curr.getData());
                curr = curr.getNext();
            }
            System.out.print(curr.getData());
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtLast(4);
        linkedList.addAtLast(5);
        linkedList.addAtLast(6);
        linkedList.addAtLast(7);
        LinkedList.print(linkedList.head);
        var reverse = LinkedList.rotateRight(linkedList.head, 3);
        System.out.println("");
        LinkedList.print(reverse);
    }

    private static <T> LinkNode<T> rotateRight(LinkNode<T> head, int k) {
        var current = head;
        for (int i=0;i<k;i++){
            current = current.getNext();
        }
        var faster = current;
        current = head;
        while (faster.getNext() != null){
            faster = faster.getNext();
            current = current.getNext();
        }
        faster.setNext(head);
        head = current.getNext();
        current.setNext(null);
        return head;
    }

    private static LinkNode<Integer> partition(LinkNode<Integer> head, Integer k) {
        var front = new LinkNode<>(0, null);
        var newHead = front;
        var rear = new LinkNode<>(k, null);
        var rearHead = rear;
        var curr = head;
        while (curr != null){
            if (curr.getData() < k){
                front.setNext(new LinkNode<>(curr.getData(), null));
                front = front.getNext();
            } else {
                rear.setNext(new LinkNode<>(curr.getData(), null));
                rear = rear.getNext();
            }
            curr = curr.getNext();
        }
        front.setNext(rearHead.getNext());
        return newHead.getNext();
    }

    private static <T> LinkNode<T> removeDublicates(LinkNode<T> head) {
        var map = new HashMap<T, Boolean>();
        var prev = head;
        map.put(prev.getData(), true);
        var current = head.getNext();
        while(current != null){
            if (map.get(current.getData()) != null){
                prev.setNext(current.getNext());
            } else {
                map.put(current.getData(), true);
            }
            prev =  current;
            current = current.getNext();
        }
        return head;
    }
}
