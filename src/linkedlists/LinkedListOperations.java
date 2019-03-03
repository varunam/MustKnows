package linkedlists;

public class LinkedListOperations {

    public static void main(String[] args){
        LinkedListUtils linkedListUtils = new LinkedListUtils();

        appendDemo(linkedListUtils);
    }

    private static void appendDemo(LinkedListUtils linkedListUtils) {
        linkedListUtils.append(10);
        linkedListUtils.append(30);
        linkedListUtils.append(4);
        linkedListUtils.printLinkedList();
    }
}
