package linkedlists;

public class LinkedList {

    private Node head;

    LinkedList() {
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

    /**
     * returns middle of the linkedlist
     * @return - node in the middle
     * ex: if there are 7 nodes, 3rd will be returned.
     * if there are 8 nodes, 4th will be returned.
     * This is helpful when you want to split linkedlist into two halves.
     *
     */
    Node getMiddleNode() {
        if (head == null || head.next == null)
            return head;

        Node fastPtr = head.next, slowPtr = head;

        while (fastPtr.next != null) {
            fastPtr = fastPtr.next;
            if (fastPtr.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
        }

        return slowPtr;
    }
}
