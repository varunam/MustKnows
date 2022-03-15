package varun.dsa.algoexpert.veryhard;

import java.util.function.Function;

/**
 *
 * Iterative In-order Traversal
 * Write a function that takes in a Binary Tree (where nodes have an additional pointer to their parent node) and
 * traverses it iteratively using! the in-order tree-traversal technique; the traversal should specifically not use
 * recursion. As the tree is being traversed, a callback function passed in as an argument to the main function should
 * be called on each node (i.e., callback(currentNode) ).
 * Each BinaryTree node has an integer value, a parent node, a left child node, and a right child node. Children nodes
 * can either be BinaryTree nodes themselves or None / null.
 *
 * Sample Input: 1
 *          /         \
 *         2           3
 *       /            /  \
 *      4           6      7
 *      \
 *        9
 * Sample Output:
 * callback(4)
 * callback(9)
 * callback(2)
 * callback(1)
 * callback(6)
 * callback(3)
 * callback(7)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Problem Link: https://www.algoexpert.io/questions/Iterative%20In-order%20Traversal
 */
public class IterativeInOrderTraversal {

    public static void main(String[] args) {
        /*BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.parent = tree;
        tree.right = new BinaryTree(3);
        tree.right.parent = tree;
        tree.parent = null;
        tree.left.left = new BinaryTree(4);
        tree.left.left.parent = tree.left;
        tree.left.left.right = new BinaryTree(9);
        tree.left.left.right.parent = tree.left.left;
        tree.right.left = new BinaryTree(6);
        tree.right.left.parent = tree.right;
        tree.right.right = new BinaryTree(7);
        tree.right.right.parent = tree.right;*/

        BinaryTree one = new BinaryTree(1, null);
        BinaryTree two = new BinaryTree(2, one);
        BinaryTree three = new BinaryTree(3, one);
        one.left = two;
        one.right = three;

        BinaryTree six = new BinaryTree(6, three);
        BinaryTree seven = new BinaryTree(7, three);
        three.left = six;
        three.right = seven;

        BinaryTree twelve = new BinaryTree(12, six);
        BinaryTree thirteen = new BinaryTree(13, six);
        six.left = twelve;
        six.right = thirteen;

        BinaryTree four = new BinaryTree(4, two);
        BinaryTree five = new BinaryTree(5, two);
        two.left = four;
        two.right = five;

        BinaryTree ten = new BinaryTree(10, five);
        BinaryTree eleven = new BinaryTree(11, five);
        five.left = ten;
        five.right = eleven;

        BinaryTree eight = new BinaryTree(8, four);
        BinaryTree nine = new BinaryTree(9 , four);
        four.left = eight;
        four.right = nine;

        iterativeInOrderTraversal(one, binaryTree -> {
            System.out.println("called for " + binaryTree.value);
            return null;
        });
    }

    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback) {
        BinaryTree previousNode = null;
        BinaryTree currentNode = tree;
        while(currentNode!=null) {
            BinaryTree nextNode;
            if(previousNode == null || previousNode ==  currentNode.parent) {
                if(currentNode.left!=null) {
                    nextNode = currentNode.left;
                } else {
                    callback.apply(currentNode);
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }
            } else if (previousNode == currentNode.left) {
                callback.apply(currentNode);
                nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
            } else {
                nextNode = currentNode.parent;
            }

            previousNode = currentNode;
            currentNode = nextNode;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
