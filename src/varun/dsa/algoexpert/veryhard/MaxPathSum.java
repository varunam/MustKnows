package varun.dsa.algoexpert.veryhard;

public class MaxPathSum {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree((7));

        int result = maxPathSum(tree);
        System.out.println("Output: " + result);
    }

    public static int maxPathSum(BinaryTree tree) {
        int[] maximum = new int[1];
        maximum[0] = Integer.MIN_VALUE;
        maxSum(tree, maximum);
        return maximum[0];
    }

    public static int maxSum(BinaryTree tree, int[] maximum) {
        if(tree == null) {
            return 0;
        }
        int leftSum = Math.max(0, maxSum(tree.left, maximum));
        int rightSum = Math.max(0, maxSum(tree.right, maximum));
        maximum[0] = Math.max(maximum[0], leftSum + rightSum + tree.value);

        return tree.value + Math.max(leftSum, rightSum);
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
