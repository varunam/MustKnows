package stack;

public class Stack {

    public static final int MAX_INT = 1000;
    public int[] array = new int[MAX_INT];
    public int top;

    public Stack() {
        top = -1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printStack();
        stack.pop();
        stack.push(10);
        stack.push(20);
        stack.push(45);
        stack.push(33);
        stack.printStack();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();

    }

    public boolean push(int data) {
        if (top > MAX_INT - 1) {
            System.out.println("Stack overflow");
            return false;
        } else {
            top++;
            array[top] = data;
            System.out.println(data + " is pushed to stack");
            return true;
        }
    }

    public boolean pop() {
        if (top < 0) {
            System.out.println("Stack underflow");
            return false;

        } else {
            System.out.println(array[top] + " is popped out");
            top--;
            return true;
        }
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void printStack() {
        if (top >= 0) {
            for (int i = top; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
            System.out.println("");
        } else {
            System.out.println("Empty stack. Nothing to print");
        }

    }
}
