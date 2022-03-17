package varun.youtube;

import varun.datastructures.BinaryTree;

import java.util.HashMap;

/**
 * Find the vertical sum at root position of a binray tree.
 * Solution explanation link: https://www.youtube.com/watch?v=il_t1WVLNxk&list=PLqM7alHXFySGqCvcwfqqMrteqWukz9ZoE
 */
public class VerticalSumOfATree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.root.left = binaryTree.newNode(2);
        binaryTree.root.right = binaryTree.newNode(3);
        binaryTree.root.left.left = binaryTree.newNode(4);
        binaryTree.root.left.right = binaryTree.newNode(5);
        binaryTree.root.right.left = binaryTree.newNode(7);
        binaryTree.root.right.right = binaryTree.newNode(6);

        int verticalSum = findVerticalSum(binaryTree);
        System.out.println("Output: " + verticalSum);
    }

    private static int findVerticalSum(BinaryTree binaryTree) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        verticalSum(binaryTree.root, 0, resultMap);
        return resultMap.get(0);
    }

    public static void verticalSum(BinaryTree.Node binaryTree, int distanceFromRoot, HashMap<Integer, Integer> resultMap) {
        if (binaryTree == null) {
            return;
        }
        if (resultMap.containsKey(distanceFromRoot)) {
            int newSum = resultMap.get(distanceFromRoot) + binaryTree.value;
            resultMap.put(distanceFromRoot, newSum);
        } else {
            resultMap.put(distanceFromRoot, binaryTree.value);
        }
        verticalSum(binaryTree.left, distanceFromRoot - 1, resultMap);
        verticalSum(binaryTree.right, distanceFromRoot + 1, resultMap);
    }
}
