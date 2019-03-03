package linkedlists;

public class LinkedListUtils {

    private Node head;

    LinkedListUtils() {
        head = null;
    }

    void append(int data) {
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

    void printLinkedList() {
        Node tempNode = head;

        if (head == null) {
            System.out.println("Empty LinkedList...");
        }
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println("");
    }

    void insertAfter(int prev_key, int data) {

        Node newNode = new Node(data);

        Node tempNode = head;
        while (tempNode.data != prev_key) {
            tempNode = tempNode.next;
        }

        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    void push(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
}
