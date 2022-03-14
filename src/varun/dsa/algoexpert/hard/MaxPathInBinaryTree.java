package varun.dsa.algoexpert.hard;

public class MaxPathInBinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(-1);

        int maxSum = maxPathSum(binaryTree);
        System.out.println("Output: " + maxSum);
    }

    public static int maxPathSum(BinaryTree tree) {
        int maxSum = tree.value;
        int leftSum = getMaxSum(tree.left, 0);
        int rightSum = getMaxSum(tree.right, 0);
        if (leftSum > 0) {
            maxSum += leftSum;
        }
        if (rightSum > 0) {
            maxSum += rightSum;
        }
        return maxSum;
    }

    public static int getMaxSum(BinaryTree tree, int sum) {
        if (tree == null) {
            return sum;
        }
        int leftSum = getMaxSum(tree.left, sum + tree.value);
        int rightSum = getMaxSum(tree.right, sum + tree.value);
        return Math.max(leftSum, rightSum);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
