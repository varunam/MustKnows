package problemsolving.linkedlist;

/**
 * Program for n’th node from the end of a Linked List
 * <p>
 * Given a Linked List and a number n, write a function that returns the value at the n’th node from end of the Linked List.
 * <p>
 * https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
 */
public class NthNodeFromEndOfLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(12);
        linkedList.push(11);
        linkedList.push(3);
        linkedList.push(5);
        linkedList.push(53);
        linkedList.push(13);

        int n = 7;
        int data = findNthFromLast(linkedList, n);
        System.out.println(n + "th Element from last of the LinkedList is : " + data);
    }

    private static int findNthFromLast(LinkedList linkedList, int n) {

        LinkedList.Node firstPointer = linkedList.head;
        LinkedList.Node lastPointer = linkedList.head;

        while (n - 1 > 0) {
            if (lastPointer.next == null) {
                return -1;
            }

            lastPointer = lastPointer.next;
            n--;
        }

        while (firstPointer.next != null && lastPointer.next != null) {
            firstPointer = firstPointer.next;
            lastPointer = lastPointer.next;
        }

        return firstPointer.data;
    }
}
