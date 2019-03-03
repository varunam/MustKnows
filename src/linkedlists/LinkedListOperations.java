package linkedlists;

public class LinkedListOperations {

    public static void main(String[] args){
        LinkedListUtils linkedListUtils = new LinkedListUtils();

        //appendDemo(linkedListUtils);
        //insertAfterDemo(linkedListUtils);
        pushDemo(linkedListUtils);
    }

    private static void appendDemo(LinkedListUtils linkedListUtils) {
        linkedListUtils.append(10);
        linkedListUtils.append(30);
        linkedListUtils.append(4);
        linkedListUtils.printLinkedList();
    }

    private static void insertAfterDemo(LinkedListUtils linkedListUtils){
        insertDummyData(linkedListUtils);
        System.out.println("Current LinkedList");
        linkedListUtils.printLinkedList();
        System.out.println("Inserting 43 after 54...");
        linkedListUtils.insertAfter(54, 43);
        System.out.println("Insert complete. Current linkedlist");
        linkedListUtils.printLinkedList();
        System.out.println("Inserting 33 after 23");
        linkedListUtils.insertAfter(23, 33);
        System.out.println("Insert complete. Current linkedlist");
        linkedListUtils.printLinkedList();
    }

    private static void pushDemo(LinkedListUtils linkedListUtils){
        linkedListUtils.printLinkedList();
        linkedListUtils.push(34);
        linkedListUtils.printLinkedList();
        linkedListUtils.push(43);
        linkedListUtils.printLinkedList();
        linkedListUtils.push(54);
        linkedListUtils.printLinkedList();
    }

    private static void insertDummyData(LinkedListUtils linkedListUtils) {
        linkedListUtils.append(10);
        linkedListUtils.append(23);
        linkedListUtils.append(34);
        linkedListUtils.append(54);
        linkedListUtils.append(76);
        linkedListUtils.append(5);
    }
}
