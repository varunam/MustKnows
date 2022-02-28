package varun.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Binary Search Tree
 */
public class BinarySearchTree {

    public BinarySearchTree(int[] inputArray) {
        for (int value : inputArray) {
            insert(value);
        }
    }

    private Node root = null;

    public class Node {
        public Node left = null;
        public Node right = null;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return root;
        }

        if (root.value <= value) {
            root.right = insert(root.right, value);
        } else {
            root.left = insert(root.left, value);
        }
        return root;
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

    public void printPreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value + "->");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printPostPorder(Node root) {
        if (root == null) {
            return;
        }

        printPostPorder(root.left);
        printPostPorder(root.right);
        System.out.println(root.value + "->");
    }

    /**
     * Problem from {@link varun.dsa.algoexpert.easy.ClosestInBst}
     *
     * @return closest element.
     */
    public int findClosest(int target) {
        return findClosest(root, target, root.value);
    }

    private int findClosest(Node root, int target, int closest) {
        Node current = root;
        while (current != null) {
            int difference = Math.abs(target - closest);
            if (difference > Math.abs(target - current.value)) {
                closest = current.value;
            }

            if (target > current.value) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return closest;
    }

    /**
     * Problem from {@link varun.dsa.algoexpert.easy.BstBranchSums}
     *
     * @return sums array.
     */
    public List<Integer> getBranchSums() {
        ArrayList<Integer> result = new ArrayList<>();
        getBranchSums(root, result, 0);
        return result;
    }

    private void getBranchSums(Node root, ArrayList<Integer> result, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(sum + root.value);
            return;
        }
        getBranchSums(root.left, result, sum + root.value);
        getBranchSums(root.right, result, sum + root.value);
    }
}
