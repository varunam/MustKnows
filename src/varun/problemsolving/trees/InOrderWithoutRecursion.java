package varun.problemsolving.trees;

import java.util.Stack;

/**
 * Using Stack is the obvious way to traverse tree without recursion. Below is an algorithm for traversing binary tree using stack. See this for step wise step execution of the algorithm.
 *
 * 1) Create an empty stack S.
 * 2) Initialize current node as root
 * 3) Push the current node to S and set current = current->left until current is NULL
 * 4) If current is NULL and stack is not empty then
 *      a) Pop the top item from stack.
 *      b) Print the popped item, set current = popped_item->right
 *      c) Go to step 3.
 * 5) If current is NULL and stack is empty then we are done.
 *
 * PROBLEM AND SOLUTION:
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 *
 */
public class InOrderWithoutRecursion {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(5, 10);
        BinarySearchTree.Node root = binarySearchTree.getRoot();

        inOrderWithoutRecursion(root);
    }

    private static void inOrderWithoutRecursion(BinarySearchTree.Node root) {

        if(root == null)
            return;

        BinarySearchTree.Node current = root;
        Stack<BinarySearchTree.Node> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }

    }
}
