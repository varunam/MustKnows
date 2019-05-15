package problemsolving.linkedlist;

public class ReverseLinkedListWithoutStack {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(12);
        linkedList.push(14);
        linkedList.push(16);
        linkedList.push(18);

        linkedList.head = reverseLinkedList(linkedList.head);
        linkedList.printList();
    }

    private static LinkedList.Node reverseLinkedList(LinkedList.Node head) {
        LinkedList.Node prev = null;
        LinkedList.Node current = head;
        LinkedList.Node next = null;
        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }

        return prev;
    }
}
