package trees.bst;

import trees.Node;

public class BstUtils {

    // root of BST
    Node root;

    public BstUtils() {
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

    //method to trees node to the tree
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

    //method to search for a key
    public boolean searchKey(int key) {
        Node foundNode = searchKey(root, key);
        return foundNode != null;
    }

    private Node searchKey(Node root, int key) {
        if (root != null) {

            //return root if key is found
            if (root.key == key)
                return root;

            //recurse down if key isn't found
            if (root.key < key) {
                return searchKey(root.right, key);
            } else {
                return searchKey(root.left, key);
            }
        } else
            return null;
    }
}
