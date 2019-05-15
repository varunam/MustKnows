package problemsolving.linkedlist;

/**
 *
 */
public class DeleteNodesHavingGreaterValueOnRight {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(3);
        linkedList.push(2);
        linkedList.push(6);
        linkedList.push(5);
        linkedList.push(11);
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(12);

        linkedList.head = deleteGreaterValuesOnRight(linkedList.head);
        linkedList.printList();

        //TODO SOLUTION IS NOT COMPLETE
        //PROBLEM HERE - https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1/?ref=self
    }

    private static LinkedList.Node deleteGreaterValuesOnRight(LinkedList.Node head) {
        while (head.next != null && head.next.data > head.data) {
            head = head.next;
        }

        LinkedList.Node current = head;
        LinkedList.Node prev = head;

        while (current.next != null) {
            if (current.next.data > current.data) {
                prev.next = current.next;
            }
            prev = current;
            current = current.next;
        }

        return head;
    }
}
