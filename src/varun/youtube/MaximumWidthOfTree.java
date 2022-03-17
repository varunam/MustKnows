package varun.youtube;

import varun.datastructures.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the maximum width of a binray tree.
 * Solution explanation link: https://www.youtube.com/watch?v=il_t1WVLNxk&list=PLqM7alHXFySGqCvcwfqqMrteqWukz9ZoE
 */
public class MaximumWidthOfTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.root.left = binaryTree.newNode(2);
        binaryTree.root.right = binaryTree.newNode(3);
        binaryTree.root.left.left = binaryTree.newNode(4);
        binaryTree.root.left.right = binaryTree.newNode(5);
        binaryTree.root.right.left = binaryTree.newNode(7);
        binaryTree.root.right.right = binaryTree.newNode(6);
        binaryTree.root.left.left.left = binaryTree.newNode(14);
        binaryTree.root.left.right.left = binaryTree.newNode(15);
        binaryTree.root.right.left.left = binaryTree.newNode(17);
        binaryTree.root.right.right.right = binaryTree.newNode(16);
        binaryTree.root.right.right.left = binaryTree.newNode(18);

        int verticalSum = findMaximumWidth(binaryTree.root);
        System.out.println("Output: " + verticalSum);
    }

    private static int findMaximumWidth(BinaryTree.Node rootNode) {
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(rootNode);
        int maximumWidth = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int tempSum = 0;
            for (int i = 0; i < queueSize; i++) {
                BinaryTree.Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    tempSum++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    tempSum++;
                }
            }
            if (tempSum > maximumWidth) {
                maximumWidth = tempSum;
            }
        }
        return maximumWidth;
    }
}
