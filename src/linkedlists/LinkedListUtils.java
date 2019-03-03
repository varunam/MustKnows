package linkedlists;

public class LinkedListUtils {

    private Node head;

    public LinkedListUtils() {
        head = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        Node tempNode = head;

        if (head == null) {
            head = new Node(data);
            return;
        }

        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;
    }

    public void printLinkedList() {
        Node tempNode = head;

        if (head == null) {
            System.out.println("Empty LinkedList...");
        }
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
    }
}
