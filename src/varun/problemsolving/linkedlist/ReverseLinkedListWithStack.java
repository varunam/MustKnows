package varun.problemsolving.linkedlist;

import java.util.Stack;

public class ReverseLinkedListWithStack {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(13);
        linkedList.push(14);
        linkedList.push(19);
        linkedList.push(18);

        linkedList.head = reverseLinkedListUsingStack(linkedList.head);
        linkedList.printList();
    }

    private static LinkedList.Node reverseLinkedListUsingStack(LinkedList.Node head) {
        Stack<LinkedList.Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            head = stack.pop();
            if (!stack.isEmpty())
                head = head.next;
        }
        return head;
    }
}
