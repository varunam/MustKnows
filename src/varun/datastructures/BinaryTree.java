package varun.datastructures;

/**
 * Implementation of Binary Search Tree
 */
public class BinaryTree {

    public Node root = null;

    public BinaryTree(int value) {
        root = new Node(value);
    }

    public Node newNode(int value) {
        return new Node(value);
    }

    public class Node {
        public Node left = null;
        public Node right = null;
        public int value;

        Node(int value) {
            this.value = value;
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.value + "->");
        printInOrder(root.right);
    }
}
