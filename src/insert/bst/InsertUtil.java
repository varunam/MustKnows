package insert.bst;

import insert.Node;

public class InsertUtil {

    // root of BST
    Node root;

    public InsertUtil() {
        root = null;
    }

    public void insert(int key) {
        root = insertNode(root, key);
    }

    public void printInOrder() {
        System.out.println("Printing In-order...");
        printInorder(root);
    }

    public void printPreOrder() {
        System.out.println("Printing pre-order...");
        printPreOrder(root);
    }

    public void printPostOrder() {
        System.out.println("Printing post-order...");
        printPostOrder(root);
    }

    private void printPostOrder(Node root) {
        if (root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.println(root.key);
        }
    }

    private void printPreOrder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    private void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.key + " ");
            printInorder(root.right);
        }
    }

    private Node insertNode(Node root, int key) {

        //if the tree is empty, create root
        if (root == null)
            root = new Node(key);

        //otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertNode(root.left, key);
        } else if (key > root.key) {
            root.right = insertNode(root.right, key);
        }

        //returning the root (unchanged)
        return root;
    }
}
