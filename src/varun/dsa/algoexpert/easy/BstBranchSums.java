package varun.dsa.algoexpert.easy;

import varun.Utils;
import varun.datastructures.BinarySearchTree;

import java.util.List;

/**
 * Branch Sums
 * Write a function that takes in a Binary Tree and returns a list of its branch sums ordered from leftmost branch
 * sum to rightmost branch sum. A branch sum is the sum of all values in a Binary Tree branch.
 * A Binary Tree branch is a path of nodes in a tree that starts at the root node and ends at any leaf node. Each
 * BinaryTree node has an integer value, a left child node, and a right child node. Children nodes can either be
 * BinaryTree nodes themselves or None / null.
 *
 * tree =    10
 *  *       /  \
 *  *      5   15
 *  *     / \  / \
 *  *    2  5 13 22
 *  *   /      \
 *  *  1       14
 * Sample Output = [ 18 20 52 47 ]
 * 15 = 1+2+4+8
 * 16 = 1+2+4+9 and so on.
 *
 * Complexity:
 * O(n) -> Time Complexity
 * O(n) -> Space Complexity
 *
 * Problem Link: https://www.algoexpert.io/questions/Branch%20Sums
 */
public class BstBranchSums {

    public static void main(String[] args) {
        int[] inputValues = new int[]{10, 5, 5, 2, 1, 15, 13, 22, 14};
        BinarySearchTree binarySearchTree = new BinarySearchTree(inputValues);
        binarySearchTree.printInOrder();

        List<Integer> branchSums = binarySearchTree.getBranchSums();
        System.out.println("\n<-- Output -->");
        Utils.print(branchSums);
    }
}
