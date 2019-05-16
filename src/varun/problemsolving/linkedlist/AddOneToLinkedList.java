package varun.problemsolving.linkedlist;

/**
 * Add 1 to a number represented as linked list
 * <p>
 * Number is represented in linked list such that each digit corresponds to a node in linked list. Add 1 to it.
 * For example 1999 is represented as (1-> 9-> 9 -> 9) and adding 1 to it should change it to (2->0->0->0)
 * <p>
 * Problem and Solution:
 * https://www.geeksforgeeks.org/add-1-number-represented-linked-list/
 */

public class AddOneToLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(9);
        linkedList.push(2);
        linkedList.push(9);
        linkedList.push(1);
        linkedList.push(9);
        linkedList.push(4);
        linkedList.push(1);
        System.out.println("Input LinkedList is ");
        linkedList.printList();

        linkedList.head = addOneToLinkedList(linkedList);

        System.out.println("Added one to the linked list");
        linkedList.printList();
    }

    private static LinkedList.Node addOneToLinkedList(LinkedList linkedList) {
        LinkedList.Node temp = ReverseLinkedListWithoutStack.reverseLinkedList(linkedList.head);
        LinkedList.Node start = temp;

        int carry = 1;
        while (start != null) {
            int value = start.data + carry;
            if (value == 10) {
                value = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            start.data = value;
            start = start.next;
        }

        LinkedList.Node reversedBack = ReverseLinkedListWithoutStack.reverseLinkedList(temp);

        if (carry == 1) {
            LinkedList.Node newNode = LinkedList.getNewNode(1);
            newNode.next = reversedBack;
            linkedList.head = newNode;
        }

        return linkedList.head;
    }
}
