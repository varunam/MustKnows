package varun.problemsolving.trees;

import java.util.Random;

public class BinarySearchTree {

    public Node root;

    class Node {

        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public BinarySearchTree() {

    }

    public BinarySearchTree(int numberOfRandomElements, int bound) {
        Random random = new Random();
        for (int i = 0; i < numberOfRandomElements; i++) {
            int value = random.nextInt(bound);
            System.out.println("Inserting " + value);
            root = insert(root, value);
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {

        Node node = new Node(data);

        if (root == null) {
            root = node;
        }

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;

    }

    public Node getRoot() {
        return root;
    }

    public void printTree() {
        System.out.println("\nPrinting InOrder");
        printInOrder(root);
        System.out.println("\nPrinting PreOrder");
        printPreOrder(root);
        System.out.println("\nPrinting PostOrder");
        printPostOrder(root);
    }

    public void printPreOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printPostOrder(Node node) {
        if (node == null)
            return;

        printPreOrder(node.left);
        printPreOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void printInOrder(Node node) {
        if (node == null)
            return;

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

}
