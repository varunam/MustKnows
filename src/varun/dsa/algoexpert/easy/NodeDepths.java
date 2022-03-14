package varun.dsa.algoexpert.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Node Depths
 * ☆
 * The distance between a node in a Binary Tree and the tree's root is called the node's depth.
 * Write a function that takes in a Binary Tree and returns the sum of its nodes' depths.
 * Each BinaryTree node has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None 7 null .
 * Sample Input
 * tree = 1
 *      /   \
 *     2    3
 *   /  \  / \
 *  4   5 6   7
 * / \
 * 8  9
 * Sample Output
 * 16
 * // The depth of the node with value 2 is 1.
 * // The depth of the node with value 3 is 1.
 * // The depth of the node with value 4 is 2.
 * // The depth of the node with value 5 is 2.
 * // Etc...
 * // Summing all of these depths yields 16.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Problem Link: https://www.algoexpert.io/questions/Node%20Depths
 */
public class NodeDepths {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);
        binaryTree.left.left.left = new BinaryTree(8);
        binaryTree.left.left.right = new BinaryTree(9);

        int depths = nodeDepths(binaryTree);
        System.out.println("Output: " + depths);
    }

    public static int nodeDepths(BinaryTree root) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        int depth = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            depth++;
            for (int i = 0; i < queueSize; i++) {
                BinaryTree node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    sum = sum + depth;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    sum = sum + depth;
                }
            }
        }
        return sum;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
