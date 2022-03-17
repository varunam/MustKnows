package varun.youtube;

import varun.dsa.common.linkedlist.LinkedList;

public class SumOfLinkedLists {

    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList();
        linkedListOne.push(2);
        linkedListOne.push(6);
        linkedListOne.push(8);
        linkedListOne.push(9);
        linkedListOne.printList();

        LinkedList linkedListTwo = new LinkedList();
        linkedListTwo.push(9);
        linkedListTwo.push(5);
        linkedListTwo.push(6);
        linkedListTwo.push(2);
        linkedListTwo.printList();

        LinkedList sum = new LinkedList();
        int[] carry = new int[]{0};
        sumOfLinkedLists(linkedListOne.head, linkedListTwo.head, sum, carry);
        if (carry[0] == 1) {
            insertNode(sum, new LinkedList.Node(1));
        }
        sum.printList();
    }

    private static void sumOfLinkedLists(LinkedList.Node linkedListOne, LinkedList.Node linkedListTwo, LinkedList result, int[] carry) {
        if (linkedListOne == null && linkedListTwo == null) {
            return;
        }
        sumOfLinkedLists(linkedListOne.next, linkedListTwo.next, result, carry);
        int sum = carry[0] + linkedListOne.data + linkedListTwo.data;
        carry[0] = sum / 10;
        int value = sum % 10;
        insertNode(result, new LinkedList.Node(value));
    }

    public static void insertNode(LinkedList result, LinkedList.Node node) {
        if (result.head == null) {
            result.head = node;
            return;
        }
        node.next = result.head;
        result.head = node;
    }
}
