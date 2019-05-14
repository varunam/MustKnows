package problemsolving.linkedlist;

/**
 * Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5
 * then output should be 3.
 *
 * If there are even nodes, then there would be two middle nodes,
 * we need to print second middle element. For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 *
 * Problem and solution:
 * https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 *
 */
public class FindCenterOfLinkedList {
    Node head; // head of linked list

    /* Linked list node */
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Function to print middle of linked list */

    /**
     * Time Complexity is O(n/2)
     * Space Complexity is O(1) with 2 pointers
     */
    void printMiddle() {
        Node slowPtr = head;
        Node fastPtr = head;

        if (head != null) {
            while (fastPtr != null && fastPtr.next != null) {
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
            }
            System.out.println("The middle element is [" + slowPtr.data + "] \n");
        }
    }

    void printMiddleUsingSinglePointer() {
        Node middle = head;
        Node tempHead = head;
        int counter = 0;
        if (head != null) {
            while (tempHead.next != null) {
                if (counter % 2 == 1) {
                    middle = middle.next;
                }
                counter++;
                tempHead = tempHead.next;
            }
            System.out.println("Middle element is " + middle.data);
        }
    }

        /* Inserts a new Node at front of the list. */
        public void push ( int new_data){
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
            Node new_node = new Node(new_data);

            /* 3. Make next of new Node as head */
            new_node.next = head;

            /* 4. Move the head to point to new Node */
            head = new_node;
        }

    /* This function prints contents of linked list
       starting from  the given node */
        public void printList () {
            Node tnode = head;
            while (tnode != null) {
                System.out.print(tnode.data + "->");
                tnode = tnode.next;
            }
            System.out.println("NULL");
        }

        public static void main (String[]args){
            FindCenterOfLinkedList llist = new FindCenterOfLinkedList();
            for (int i = 5; i > 0; --i) {
                llist.push(i);
                llist.printList();
                llist.printMiddleUsingSinglePointer();
            }
        }
    }
