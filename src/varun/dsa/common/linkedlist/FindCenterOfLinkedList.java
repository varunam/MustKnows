package varun.dsa.common.linkedlist;

import varun.dsa.common.linkedlist.LinkedList.Node;

/**
 * Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5
 * then output should be 3.
 * <p>
 * If there are even nodes, then there would be two middle nodes,
 * we need to print second middle element. For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 * <p>
 * Problem and solution:
 * https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 */
public class FindCenterOfLinkedList {

    /* Function to print middle of linked list */

    /**
     * Time Complexity is O(n/2)
     * Space Complexity is O(1) with 2 pointers
     */
    static void printMiddle(LinkedList.Node head) {
        LinkedList.Node slowPtr = head;
        LinkedList.Node fastPtr = head;

        if (head != null) {
            while (fastPtr != null && fastPtr.next != null) {
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
            }
            System.out.println("The middle element is [" + slowPtr.data + "] \n");
        }
    }

    static void printMiddleUsingSinglePointer(Node head) {
        Node middle = head;
        Node tempHead = head;
        int counter = 0;
        if (head != null) {
            while (tempHead.next != null) {
                if (counter % 2 == 1) {
                    middle = middle.next;
                }
                counter++;
                tempHead = tempHead.next;
            }
            System.out.println("Middle element is " + middle.data);
        }
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        for (int i = 5; i > 0; --i) {
            llist.push(i);
            llist.printList();
            //printMiddleUsingSinglePointer(llist.head);
            printMiddle(llist.head);
        }
    }
}
