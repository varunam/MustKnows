package varun.problemsolving.linkedlist;

import java.util.Queue;
import java.util.Stack;

import varun.problemsolving.linkedlist.LinkedList.Node;

/**
 * Given a singly linked list of size N. The task is to rotate the linked list counter-clockwise by k nodes,
 * where k is a given positive integer smaller than or equal to length of the linked list.
 *
 * Problem and Solution
 * https://www.geeksforgeeks.org/rotate-a-linked-list/
 *
 */
public class RotateLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(10, 10);
        System.out.println("Input Linked List is ");
        linkedList.printList();

        int rotateCount = 7;
        //rotateLinkedList(linkedList, rotateCount);
        System.out.println("Output linkedlist is ");
        //linkedList.printList();

        rotateLinkedListWithoutQueue(linkedList, rotateCount);
    }

    /**
     * Solution with using Queue
     *
     * @param linkedList
     * @param rotateCount
     * @return
     */
    private static LinkedList.Node rotateLinkedList(LinkedList linkedList, int rotateCount) {
        LinkedList.Node temp = linkedList.head;
        Queue<LinkedList.Node> queue = new java.util.LinkedList<LinkedList.Node>();

        for (int i = 0; i < rotateCount; i++) {
            queue.add(temp);
            temp = temp.next;
        }

        linkedList.head = temp;

        while (temp.next != null) {
            temp = temp.next;
        }

        while (!queue.isEmpty()) {
            temp.next = ((java.util.LinkedList<LinkedList.Node>) queue).pop();
            temp = temp.next;
        }

        temp.next = null;

        return linkedList.head;
    }

    /**
     * Solution without using queue
     */
    private static void rotateLinkedListWithoutQueue(LinkedList linkedList, int rotateCount) {
        //add code here.
        Node temp = linkedList.head;
        while (temp.next != null) {
            temp = temp.next;

        }
        Node temp1 = linkedList.head;
        while (rotateCount != 0 && temp1.next != null) {
            temp.next = temp1;

            linkedList.head = temp1.next;
            temp1.next = null;
            temp1 = linkedList.head;
            temp = temp.next;
            rotateCount--;
            //System.out.println(temp.data + " "+ temp1.data + " " + head.data);
        }
        while (temp1 != null) {
            System.out.print(temp1.data + " ");
            temp1 = temp1.next;
        }
    }
}
