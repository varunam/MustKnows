package problemsolving.linkedlist;

public class DeleteMiddleOfLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(23);
        linkedList.push(22);
        linkedList.push(55);
        linkedList.push(24);

        deleteMiddle(linkedList.head);
        linkedList.printList();
    }

    private static void deleteMiddle(LinkedList.Node head) {
        LinkedList.Node slow = head;
        LinkedList.Node fast = head;

        LinkedList.Node tempNode = head;

        while (fast != null && fast.next != null) {
            tempNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        tempNode.next = slow.next;

    }
}
