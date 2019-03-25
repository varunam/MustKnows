package problemsolving.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Video - https://youtu.be/il_t1WVLNxk?t=90
 * Question 2
 * Code and explanation - https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 */

public class MaxWidthInTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class Tree {

        public Node root;

        public Tree() {
            root = null;
        }

        public void insertData(int data) {
            root = insert(root, data);
        }

        private Node insert(Node root, int data) {
            Node newNode = new Node(data);

            if (root == null)
                root = newNode;

            if (data > root.data) {
                root.right = insert(root.right, data);
            } else if (data < root.data) {
                root.left = insert(root.left, data);
            }

            return root;
        }

        public void print() {
            printInOrder(root);
        }

        private void printInOrder(Node root) {
            if (root != null) {
                printInOrder(root.left);
                System.out.print(root.data + " ");
                printInOrder(root.right);
            }
        }


        public void printMaxWidth() {
            if (root == null)
                return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int maxWidth = 0;
            while (!queue.isEmpty()) {
                int count = 0;
                count = queue.size();
                if (count > maxWidth)
                    maxWidth = count;

                while (count > 0) {
                    Node temp = queue.remove();
                    if (temp.left != null)
                        ((LinkedList<Node>) queue).add(temp.left);
                    if (temp.right != null)
                        ((LinkedList<Node>) queue).add(temp.right);
                    count--;
                }
            }
            System.out.println("\nMax Width: " + maxWidth);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertData(10);
        tree.insertData(15);
        tree.insertData(20);
        tree.insertData(5);
        tree.insertData(16);
        tree.insertData(17);
        tree.insertData(21);
        tree.insertData(13);
        tree.insertData(3);
        tree.insertData(6);
        tree.print();

        tree.printMaxWidth();
    }
}
