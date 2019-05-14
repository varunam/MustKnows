package problemsolving.linkedlist;

import java.util.HashSet;

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
