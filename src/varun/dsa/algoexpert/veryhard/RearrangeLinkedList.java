package varun.dsa.algoexpert.veryhard;

/**
 * Rearrange Linked List
 * Write a function that takes in the head of a Singly Linked List and an integer k, rearranges the list in place
 * (i.e., doesn't create a brand new list) around nodes with value k , and returns its new head.
 * Rearranging a Linked List around nodes with value k means moving all nodes with a value smaller than k before all
 * nodes with value k and moving all nodes with a value greater than k after all nodes with value k.
 * All moved nodes should maintain their original relative ordering if possible,
 * Note that the linked list should be rearranged even if it doesn't have any nodes with value k.
 * Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to
 * None / null if it's the tail of the list.
 * You can assume that the input Linked List will always have at least one node; in other words, the head will
 * never be None / null.
 *
 * Sample Input
 * head = 3 -> k = 3
 * -> 5 -> 2 -> 1 -> 4 // the head node with value 3
 * Sample Output
 * 0 => 2 -> 1 -> 3 -> 5 -> 4 // the new head node with value // Note that the nodes with values 0, 2, and 1 have
 * maintained their original relative ordering, and so have the nodes with values 5 and 4.
 *
 * Time Complexity -> O(n)
 * Space Complexity -> O(1)
 *
 * Problem Link: https://www.algoexpert.io/questions/Rearrange%20Linked%20List
 */
public class RearrangeLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(3);
        list.next = new LinkedList(0);
        list.next.next = new LinkedList(5);
        list.next.next.next = new LinkedList(2);
        list.next.next.next.next = new LinkedList(1);
        list.next.next.next.next.next = new LinkedList(4);

        System.out.println("<-- Input -->");
        printLinkedList(list);
        System.out.println("<-- Output -->");
        LinkedList result = rearrangeLinkedList(list, 3);
        printLinkedList(result);
    }

    private static void printLinkedList(LinkedList result) {
        System.out.print("[");
        while(result !=null) {
            System.out.print(" " + result.value);
            result = result.next;
        }
        System.out.println(" ]");
    }

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedList smallHead = null;
        LinkedList smallTail = null;
        LinkedList equalHead = null;
        LinkedList equalTail = null;
        LinkedList greaterHead = null;
        LinkedList greaterTail = null;

        LinkedList current = head;
        while(current!=null) {
            if(current.value > k) {
                LinkedListPair pair = growLinkedList(greaterHead, greaterTail, current);
                greaterHead = pair.head;
                greaterTail = pair.tail;
            } else if (current.value < k) {
                LinkedListPair pair = growLinkedList(smallHead, smallTail, current);
                smallHead = pair.head;
                smallTail = pair.tail;
            } else {
                LinkedListPair pair = growLinkedList(equalHead, equalTail, current);
                equalHead = pair.head;
                equalTail = pair.tail;
            }

            LinkedList prev = current;
            current = current.next;
            prev.next = null;
        }

        LinkedListPair firstPair = connectLinkedLists(smallHead, smallTail, equalHead, equalTail);
        LinkedListPair finalPair = connectLinkedLists(firstPair.head, firstPair.tail, greaterHead, greaterTail);
        return finalPair.head;
    }

    public static LinkedListPair growLinkedList(LinkedList head, LinkedList tail, LinkedList node) {
        LinkedList newHead = head;
        LinkedList newTail = node;

        if(newHead == null) {
            newHead = node;
        }
        if(tail!=null) {
            tail.next = node;
        }
        return new LinkedListPair(newHead, newTail);
    }

    public static LinkedListPair connectLinkedLists(LinkedList firstHead, LinkedList firstTail,
                                                    LinkedList secHead, LinkedList secTail) {
        LinkedList newHead = firstHead == null ? secHead : firstHead;
        LinkedList newTail = secTail == null ? firstTail : secTail;

        if(firstTail != null) {
            firstTail.next = secHead;
        }

        return new LinkedListPair(newHead, newTail);
    }

    public static class LinkedListPair {
        public LinkedList head;
        public LinkedList tail;
        public LinkedListPair(LinkedList head, LinkedList tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
