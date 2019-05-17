package varun.problemsolving.linkedlist;

import varun.problemsolving.linkedlist.LinkedList.Node;

public class RemoveLoopLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;

        System.out.println("Input linked list");
        //list.printList();

        detectAndRemoveLoop(list.head);
        System.out.println("Linked List after removing loop : ");
        list.printList();
    }

    private static void detectAndRemoveLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeLoop(slow, head);
                return;
            }
        }

    }

    private static void removeLoop(Node loopStart, Node head) {
        Node firstPtr = loopStart;
        Node secondPtr = loopStart;

        int loopSize = 1;
        while (firstPtr.next != secondPtr) {
            firstPtr = firstPtr.next;
            loopSize++;
        }

        firstPtr = head;
        secondPtr = head;

        for (int i = 0; i < loopSize; i++) {
            secondPtr = secondPtr.next;
        }

        while (secondPtr != firstPtr) {
            secondPtr = secondPtr.next;
            firstPtr = firstPtr.next;
        }

        while (secondPtr.next != firstPtr) {
            secondPtr = secondPtr.next;
        }

        secondPtr.next = null;
    }
}
