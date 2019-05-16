package varun.linkedlists;

public class LinkedListOperations {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        //appendDemo(linkedList);
        //insertAfterDemo(linkedList);
        //pushDemo(linkedList);
        getMiddleNodeDemo(linkedList);
    }

    private static void appendDemo(LinkedList linkedList) {
        linkedList.append(10);
        linkedList.append(30);
        linkedList.append(4);
        linkedList.printLinkedList();
    }

    private static void insertAfterDemo(LinkedList linkedList) {
        insertDummyData(linkedList);
        System.out.println("Current LinkedList");
        linkedList.printLinkedList();
        System.out.println("Inserting 43 after 54...");
        linkedList.insertAfter(54, 43);
        System.out.println("Insert complete. Current linkedlist");
        linkedList.printLinkedList();
        System.out.println("Inserting 33 after 23");
        linkedList.insertAfter(23, 33);
        System.out.println("Insert complete. Current linkedlist");
        linkedList.printLinkedList();
    }

    private static void pushDemo(LinkedList linkedList) {
        linkedList.printLinkedList();
        linkedList.push(34);
        linkedList.printLinkedList();
        linkedList.push(43);
        linkedList.printLinkedList();
        linkedList.push(54);
        linkedList.printLinkedList();
    }

    private static void insertDummyData(LinkedList linkedList) {
        linkedList.append(10);
        linkedList.append(23);
        linkedList.append(34);
        linkedList.append(54);
        linkedList.append(76);
        linkedList.append(5);
    }

    private static void getMiddleNodeDemo(LinkedList linkedList) {
        insertDummyData(linkedList);
        linkedList.printLinkedList();
        Node middleNode = linkedList.getMiddleNode();
        System.out.println("Middle node: " + middleNode.data);
    }
}
