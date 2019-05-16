package varun.problemsolving.trees;

import java.util.HashMap;

public class VerticalSumTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class Tree {

        private Node root;

        public Tree() {
            this.root = null;
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

        public void printVerticalSum() {
            printVerticalSum(root);
        }

        private void printVerticalSum(Node root) {
            if (root == null)
                return;

            HashMap<Integer, Integer> hashMap = new HashMap<>();
            getVerticalSumMap(root, 0, hashMap);

            System.out.println(hashMap.entrySet());
        }

        private void getVerticalSumMap(Node root, int key, HashMap<Integer, Integer> resultMap) {
            if (root == null)
                return;

            getVerticalSumMap(root.left, key - 1, resultMap);

            int prevSum = (resultMap.get(key) == null ? 0 : resultMap.get(key));
            resultMap.put(key, prevSum + root.data);

            getVerticalSumMap(root.right, key + 1, resultMap);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insertData(10);
        tree.insertData(24);
        tree.insertData(34);
        tree.insertData(45);
        tree.insertData(4);
        tree.insertData(22);
        tree.insertData(2);
        tree.print();

        tree.printVerticalSum();
    }
}
