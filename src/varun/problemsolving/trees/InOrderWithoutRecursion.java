package varun.problemsolving.trees;

import java.util.Stack;

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
