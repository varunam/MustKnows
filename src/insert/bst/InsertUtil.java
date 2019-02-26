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
        printInOrder();
    }

    public void printInOrder(){
        printInorder(root);
    }

    public void printInorder(Node root) {
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
