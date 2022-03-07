package varun.dsa.algoexpert.medium;

import varun.datastructures.BinaryTree;

/**
 * Invert Binary Tree
 * Write a function Mat takes in a Binary Tree and inverts it. In other words, the function should swap every left node
 * in the tree for its corresponding right node. Each Binaryrree node has an integer value ,a left child node,
 * and a right Mild node. Children nodes can either he Binary7ree nodes themselves or None / null .
 *
 * Sample Input: 1
 *             /  \
 *            2    3
 *           / \    \
 *          4   5    6
 *
 * Sample Output: 1
 *              /  \
 *             3    2
 *            /    / \
 *           6    5   4
 *
 * Complexities:
 * O(n) -> Time Complexity where n is the number of nodes.
 * O(d) -> Space Complexity where d is the depth of the node.
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.root.left = binaryTree.newNode(2);
        binaryTree.root.right = binaryTree.newNode(3);
        binaryTree.root.left.left = binaryTree.newNode(4);
        binaryTree.root.left.right = binaryTree.newNode(5);
        binaryTree.root.right.right = binaryTree.newNode(6);

        System.out.println("<-- Input -->");
        binaryTree.printInOrder();
        invertBinaryTree(binaryTree.root);
        System.out.println("\n<-- Output -->");
        binaryTree.printInOrder();
    }

    private static void invertBinaryTree(BinaryTree.Node tree) {
        if(tree==null) {
            return;
        }

        BinaryTree.Node temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }
}
