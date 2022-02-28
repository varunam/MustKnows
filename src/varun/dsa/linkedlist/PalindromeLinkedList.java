package varun.dsa.linkedlist;

/**
 * Function to check if a singly linked list is palindrome
 * <p>
 * Given a singly linked list of characters, write a function that returns true if the given list is palindrome, else false.
 *
 * METHOD 1 (Use a Stack)
 * A simple solution is to use a varun.stack of list nodes. This mainly involves three steps.
 * 1) Traverse the given list from head to tail and push every visited node to varun.stack.
 * 2) Traverse the list again. For every visited node, pop a node from varun.stack and compare data of popped node with currently visited node.
 * 3) If all nodes matched, then return true, else false.
 *
 * Time complexity of above method is O(n), but it requires O(n) extra space. Following methods solve this with constant extra space.
 *
 * Given below is the solution 2 which takes time complexity of O(n) but space complexity of O(1)\
 *
 * METHOD 2 (By reversing the list)
 * This method takes O(n) time and O(1) extra space.
 * 1) Get the middle of the linked list.
 * 2) Reverse the second half of the linked list.
 * 3) Check if the first half and second half are identical.
 * 4) Construct the original linked list by reversing the second half again and attaching it back to the first half
 *
 *
 * PROBLEM AND SOLUTION:
 * https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 *
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.push(10);
        linkedList.push(11);
        linkedList.push(12);
        linkedList.push(13);
        linkedList.push(12);
        linkedList.push(11);
        linkedList.push(10);

        System.out.println("Given LinkedList is ");
        linkedList.printList();

        boolean palindrome = checkIfPalindrome(linkedList);
        System.out.println("Given Linkedlist is palindrome: " + palindrome);

        System.out.println("LinkedList at the end of result");
        linkedList.printList();

    }

    private static boolean checkIfPalindrome(LinkedList linkedList) {
        LinkedList.Node slowPtr = linkedList.head;
        LinkedList.Node fastPtr = linkedList.head;
        LinkedList.Node middleNode = linkedList.head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        //once loop is finished, fastPtr will be null in case of even elements and not null in case of odd elements
        if (fastPtr != null) {
            middleNode = slowPtr;
            slowPtr = slowPtr.next;
        }

        LinkedList.Node second_half = slowPtr;
        second_half = ReverseLinkedListWithoutStack.reverseLinkedList(second_half);
        boolean result = compareLinkedLists(linkedList.head, second_half);
        second_half = ReverseLinkedListWithoutStack.reverseLinkedList(second_half);

        middleNode.next = second_half;

        System.out.println("Middle node: " + slowPtr.data + " Fast ptr: " + fastPtr);
        return result;
    }

    private static boolean compareLinkedLists(LinkedList.Node head, LinkedList.Node second_half) {
        while (head != null && second_half != null) {
            if (head.data == second_half.data) {
                head = head.next;
                second_half = second_half.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
