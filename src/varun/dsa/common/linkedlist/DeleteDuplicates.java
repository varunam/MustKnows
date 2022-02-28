package varun.dsa.common.linkedlist;

import java.util.HashSet;

/**
 * Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted.
 * <p>
 * For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43.
 * <p>
 * Problem and solution:
 * https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(11);
        linkedList.push(11);
        linkedList.push(11);
        linkedList.push(23);
        linkedList.push(23);
        linkedList.push(53);
        linkedList.push(32);

        removeDuplicate(linkedList.head);
        linkedList.printList();
    }

    static void removeDuplicate(LinkedList.Node head) {
        HashSet<Integer> hashSet = new HashSet<>();

        LinkedList.Node prev = null;
        LinkedList.Node current = head;

        while (current != null) {
            if (hashSet.contains(current.data)) {
                prev.next = current.next;
            } else {
                hashSet.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

}
