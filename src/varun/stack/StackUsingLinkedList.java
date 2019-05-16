package varun.stack;

public class StackUsingLinkedList {

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.printStack();
        stack.push(10);
        stack.push(20);
        stack.push(43);
        stack.push(53);
        stack.peek();
        stack.push(56);
        stack.printStack();
        stack.pop();
        stack.peek();
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
    }

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            System.out.println("Empty varun.stack. Stack created with " + data);
            return;
        }
        System.out.println(data + " is pushed to the varun.stack");
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (top == null) {
            System.out.println("Empty varun.stack. Nothing to pop");
        } else {
            System.out.println(top.data + " is popped out");
            top = top.next;
        }
    }

    public void peek() {
        if (top != null)
            System.out.println(top.data+"");
        else {
            System.out.println("Stack is empty");
            return;
        }
    }

    public void printStack() {
        if (top == null) {
            System.out.println("Stack empty. Nothing to print");
            return;
        } else {
            Node tempNode = top;
            while (tempNode != null) {
                System.out.print(tempNode.data + " ");
                tempNode = tempNode.next;
            }
            System.out.println("");
        }
    }
}
