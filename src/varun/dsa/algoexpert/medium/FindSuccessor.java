package varun.dsa.algoexpert.medium;

import varun.datastructures.BinaryTree;

import java.util.ArrayList;

/**
 * Find Successor
 * Write a function that takes in a Binary Tree (where nodes have an additional pointer to their parent node) as well
 * as a node contained in that tree and returns the given node's successor.
 * A node's successor is the next node to be visited (immediately after the given node) when traversing its tree using
 * the in-order tree. traversal technique. A node has no successor if it's the last node to be visited in the in-order traversal.
 * If a node has no successor, your function should return None / null,
 * Each BinaryTree node has an integer value, a parent node, a left child node, and a right child node. Children nodes
 * can either be BinaryTree nodes themselves or None 7 null
 *
 * Sample Input:  1
 *              /  \
 *             2    3
 *            / \
 *           4   5
 *          /
 *         6
 * Node: 5
 *
 * Sample Output
 * // This tree's in-order traversal order is: // 6 -> 4 -> 2 -> 5 > 1 -> 3 // 1 comes immediately after 5.
 **/

public class FindSuccessor {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.root.left = binaryTree.newNode(2);
        binaryTree.root.right = binaryTree.newNode(3);
        binaryTree.root.left.left = binaryTree.newNode(4);
        binaryTree.root.left.right = binaryTree.newNode(5);
        binaryTree.root.left.left = binaryTree.newNode(6);

        System.out.println("<-- Input -->");
        binaryTree.printInOrder();
        BinaryTree.Node successor = findSuccessor(binaryTree.root, binaryTree.root.left.right);
        System.out.println("\n<-- Output -->");
        System.out.println("Successor: " + successor.value);
    }

    public static BinaryTree.Node findSuccessor(BinaryTree.Node tree, BinaryTree.Node node) {
        ArrayList<BinaryTree.Node> order = new ArrayList<>();
        getInOrderTraversalOrder(tree, order);

        for(int i = 0; i<order.size(); i++) {
            BinaryTree.Node currentNode = order.get(i);

            if(currentNode!=node) {
                continue;
            }

            if(i == order.size() - 1) {
                return null;
            }
            return order.get(i + 1);
        }
        return null;
    }

    static void getInOrderTraversalOrder(BinaryTree.Node node, ArrayList<BinaryTree.Node> order) {
        if(node == null) {
            return;
        }

        getInOrderTraversalOrder(node.left, order);
        order.add(node);
        getInOrderTraversalOrder(node.right, order);
    }
}
