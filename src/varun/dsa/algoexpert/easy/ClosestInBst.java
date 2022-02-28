package varun.dsa.algoexpert.easy;

import varun.datastructures.BinarySearchTree;

/**
 * Find Closest Value In BST
 * Write a function that takes in a Binary Search Tree (BST) and a target integer value and returns the closest
 * value to that target value contained in the BST.
 * <p>
 * You can assume that there will only be one closest value.
 * <p>
 * Each BST node has an integer value, a left child node, and a right child node. A node is said to be a valid BST node
 * if and only if it satisfies the BST property: its value is strictly greater than the values of every node to its left;
 * its value is less than or equal to the values of every node to its right; and its children nodes are either valid
 * BST nodes themselves or None / null .
 * <p>
 * Sample Input:
 * tree = 10
 *       /  \
 *      5   15
 *     / \  / \
 *    2  5 13 22
 *   /      \
 *  1       14
 * target = 12
 * Sample Output = 13
 * <p>
 * Complexity:
 * O(logn) -> Time Complexity where n is the number of nodes.
 * O(n) -> Worst case.
 * O(1) -> Space Complexity
 */
public class ClosestInBst {

    public static void main(String[] args) {
        int[] inputValues = new int[]{10, 5, 5, 2, 1, 15, 13, 22, 14};
        BinarySearchTree binarySearchTree = new BinarySearchTree(inputValues);
        System.out.println("<-- Input Tree In-Order Traversal -->");
        binarySearchTree.printInOrder();
        System.out.println("");
        int target = 12;

        int closest = binarySearchTree.findClosest(target);
        System.out.println("Found Closest: " + closest);
    }
}
