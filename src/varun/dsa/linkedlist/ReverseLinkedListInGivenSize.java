package varun.dsa.linkedlist;

/**
 *
 Reverse a Linked List in groups of given size | Set 1

 Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 Example:

 Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
 Output:  3->2->1->6->5->4->8->7->NULL.

 Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 Output:  5->4->3->2->1->8->7->6->NULL.

 Problem and Solution:
 Using Recursion -
 https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

 Using Stack -
 https://www.geeksforgeeks.org/reverse-linked-list-groups-given-size-set-2/

 */
public class ReverseLinkedListInGivenSize {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(11);
        linkedList.push(14);
        linkedList.push(17);
        linkedList.push(18);

        linkedList.head = reverseLinkedListOnce(linkedList.head, 2);
        linkedList.printList();
    }

    /**
     *
     * @param head - supplied head
     * @param givenSize - size at which items have to be reversed
     * @return
     */
    private static LinkedList.Node reverseLinkedList(LinkedList.Node head, int givenSize) {
        LinkedList.Node prev = null, next = null;
        LinkedList.Node current = head;
        int size = 0;
        while (current != null && size < givenSize) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            size++;
        }
        if (next != null) {
            head.next = reverseLinkedList(next, givenSize);
        }
        return prev;
    }

    private static LinkedList.Node reverseLinkedListOnce(LinkedList.Node head, int givenSize) {
        LinkedList.Node prev = null, next = null;
        LinkedList.Node current = head;
        int size = givenSize;
        while (current != null) {
            if (size > 0) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                size--;
            } else {
                head.next = current;
                head = prev;
                break;
            }
        }
        return head;
    }
}
