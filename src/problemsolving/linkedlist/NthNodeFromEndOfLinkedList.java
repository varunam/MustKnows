package problemsolving.linkedlist;

public class NthNodeFromEndOfLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(12);
        linkedList.push(11);
        linkedList.push(3);
        linkedList.push(5);
        linkedList.push(53);
        linkedList.push(13);

        int n = 7;
        int data = findNthFromLast(linkedList, n);
        System.out.println(n + "th Element from last of the LinkedList is : " + data);
    }

    private static int findNthFromLast(LinkedList linkedList, int n) {

        LinkedList.Node firstPointer = linkedList.head;
        LinkedList.Node lastPointer = linkedList.head;

        while (n - 1 > 0) {
            if (lastPointer.next == null) {
                return -1;
            }

            lastPointer = lastPointer.next;
            n--;
        }

        while (firstPointer.next != null && lastPointer.next != null) {
            firstPointer = firstPointer.next;
            lastPointer = lastPointer.next;
        }

        return firstPointer.data;
    }
}
