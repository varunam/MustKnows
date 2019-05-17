package varun.problemsolving.trees;

/**
 * A program to check if a binary tree is BST or not
 *
 * A binary search tree (BST) is a node based binary tree data structure which has the following properties.
 * • The left subtree of a node contains only nodes with keys less than the node’s key.
 * • The right subtree of a node contains only nodes with keys greater than the node’s key.
 * • Both the left and right subtrees must also be binary search trees.
 *
 * PROBLEM AND SOLUTION
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 *
 */
public class CheckIfTreeIsBST {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(5, 10);
        boolean isBst = isTheTreeBST(binarySearchTree.getRoot());
        System.out.println("Given tree is BST? " + isBst);
    }

    private static boolean isTheTreeBST(BinarySearchTree.Node root) {
        return isTheTreeBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isTheTreeBST(BinarySearchTree.Node root, int minValue, int maxValue) {

        if (root == null)
            return true;

        if (root.data > maxValue || root.data < minValue) {
            return false;
        }

        return isTheTreeBST(root.left, minValue, root.data - 1) &&
                isTheTreeBST(root.right, root.data + 1, maxValue);
    }
}
