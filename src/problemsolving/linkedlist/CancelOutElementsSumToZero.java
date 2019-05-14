package problemsolving.linkedlist;

import stack.Stack;

public class CancelOutElementsSumToZero {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(-10);
        linkedList.push(8);
        linkedList.push(4);
        linkedList.push(-12);
        linkedList.push(3);
        linkedList.push(5);
        linkedList.push(-5);
        linkedList.push(-3);

        LinkedList result = cancelOut(linkedList.head);
    }

    private static LinkedList cancelOut(LinkedList.Node head) {
        LinkedList result = new LinkedList();

        //TODO yet to find the solution

        return result;
    }

}
