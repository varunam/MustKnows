package varun.problemsolving.linkedlist;

public class FindLoopInLinkedList {

    public static Node findStartPointOfLoop(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head;

        slow = slow.next;
        fast = fast.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != fast)
            return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);

        /* Create a loop for testing */
        head.next.next.next.next.next = head.next.next;

        Node res = findStartPointOfLoop(head);
        if (res == null)
            System.out.println("Loop does not exist");
        else
            System.out.println("Loop starting node is " + res.data);

    }
}
