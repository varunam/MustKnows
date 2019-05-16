package problemsolving.linkedlist;

import java.util.Stack;

/**
 *
 */
public class DeleteNodesHavingGreaterValueOnRight {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(6);
        linkedList.push(10);
        linkedList.push(3);
        linkedList.push(12);
        linkedList.push(9);
        linkedList.push(0);
        linkedList.push(14);
        linkedList.push(16);
        linkedList.push(9);
        linkedList.push(5);
        linkedList.push(10);
        linkedList.push(3);

        linkedList.printList();
        linkedList.head = deleteGreaterValuesOnRightWithoutStack(linkedList.head);
        linkedList.printList();

    }

    /**
     * The below method stores the result in stack
     * but the problem is to track stack to the linkedlist
     * when a node is popped, it is difficult to bring top pointer to down.
     * <p>
     * So correct solution is given in below method!!
     *
     * @param head - head of the linkedlist
     * @return
     */
    private static LinkedList.Node deleteGreaterValuesOnRight(LinkedList.Node head) {

        Stack<LinkedList.Node> stack = new Stack<>();
        LinkedList.Node temp = head;
        while (temp != null) {
            if (stack.isEmpty()) {
                stack.push(temp);
            } else {
                while (!stack.isEmpty() && stack.peek().data < temp.data) {
                    stack.pop();
                }
                stack.push(temp);
            }
            temp = temp.next;
        }
        return head;
    }

    private static LinkedList.Node deleteGreaterValuesOnRightWithoutStack(LinkedList.Node head) {

        LinkedList.Node reversedHead = ReverseLinkedListWithoutStack.reverseLinkedList(head);

        LinkedList.Node current = reversedHead;
        LinkedList.Node maxNode = reversedHead;

        while (current.next != null) {
            if (maxNode.data > current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
                maxNode = current;
            }
        }

        return ReverseLinkedListWithoutStack.reverseLinkedList(reversedHead);
    }
}
