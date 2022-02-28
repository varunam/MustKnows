package varun.dsa.linkedlist;

import java.util.Scanner;

public class SumOfNodesBetweenZero {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println("Please enter number of elements");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Please enter " + n + " elements.");
        for (int i = 0; i < n; i++) {
            linkedList.push(scanner.nextInt());
        }

        linkedList.head = sumOfNodesBetweenZero(linkedList.head);
        linkedList.printList();
    }

    private static LinkedList.Node sumOfNodesBetweenZero(LinkedList.Node head) {
        int sum = 0;
        LinkedList.Node temp = head;
        LinkedList.Node resultNode = head;

        while (head.data == 0) {
            head = head.next;
        }

        while (temp != null) {

            if (temp.data != 0) {
                sum = sum + temp.data;
                temp = temp.next;
            } else {
                resultNode.data = sum;
                resultNode.next = temp.next;
                temp = resultNode.next;
                resultNode = resultNode.next;
                sum = 0;
            }
        }

        return head;
    }
}
