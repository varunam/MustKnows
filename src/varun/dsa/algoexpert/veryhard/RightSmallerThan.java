package varun.dsa.algoexpert.veryhard;

import varun.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Right Smaller than
 * <p>
 * Write a function that takes in an array of integers and returns an array of the same length, where each element in
 * the output array corresponds to the number of integers in the input array that are to the right of the relevant index
 * and that are strictly smaller than the integer at that index.
 * In other words, the value at output[i] represents the number of integers that are to the right of i and that are
 * strictly smaller than input[i].
 * <p>
 * Sample Input
 * array = [8, 5, 11, -1, 3, 4, 2]
 * Sample Output
 * [5, 4, 4, 0, 1, 1, 0]
 * // There are 5 integers smaller than 8 to the right of it.
 * // There are 4 integers smaller than 5 to the right of it.
 * // There are 4 integers smaller than 11 to the right of it.
 * // Etc...
 * <p>
 * Time Complexity: O(nlog(n))
 * Space Complexity: O(n)
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Right%20Smaller%20Than
 */
public class RightSmallerThan {

    public static void main(String[] args) {
        int[] input = new int[]{8, 5, 11, -1, 3, 4, 2};
        List<Integer> inputList = new ArrayList<>();
        for(int value: input) {
            inputList.add(value);
        }
        System.out.println("<--Input-->");
        Utils.print(input);
        List<Integer> result = rightSmallerThan(inputList);
        System.out.println("<--Output-->");
        Utils.print(result);
    }

    public static List<Integer> rightSmallerThanBruteForce(List<Integer> array) {
        List<Integer> result = new ArrayList<>();
        for(int f = 0; f<array.size(); f++) {
            int s = array.size() - 1;
            int counter = 0;
            while(s!=f) {
                if(array.get(s)<array.get(f)) {
                    counter++;
                }
                s--;
            }
            result.add(counter);
        }
        return result;
    }

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size() == 0) return new ArrayList<>();

        int lastIndex = array.size() - 1;
        SpecialBST bst = new SpecialBST(array.get(lastIndex), lastIndex, 0);
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i);
        }

        List<Integer> rightSmallerAmounts = new ArrayList<>(array);
        getRightSmallerAmounts(bst, rightSmallerAmounts);
        return rightSmallerAmounts;
    }

    public static void getRightSmallerAmounts(SpecialBST bst, List<Integer> rightSmallerAmounts) {
        if (bst == null) return;
        rightSmallerAmounts.set(bst.index, bst.numSmallerAtInsertionTime);
        getRightSmallerAmounts(bst.left, rightSmallerAmounts);
        getRightSmallerAmounts(bst.right, rightSmallerAmounts);
    }

    static class SpecialBST {
        public int value;
        public int index;
        public int numSmallerAtInsertionTime;
        public int leftSubtreeSize;
        public SpecialBST left;
        public SpecialBST right;

        public SpecialBST(int value, int index, int numSmallerAtInsertionTime) {
            this.value = value;
            this.index = index;
            this.numSmallerAtInsertionTime = numSmallerAtInsertionTime;
            leftSubtreeSize = 0;
            left = null;
            right = null;
        }

        public void insert(int value, int index) {
            insertHelper(value, index, 0);
        }

        public void insertHelper(int value, int index, int numSmallerAtInsertionTime) {
            if (value < this.value) {
                leftSubtreeSize++;
                if (left == null) {
                    left = new SpecialBST(value, index, numSmallerAtInsertionTime);
                } else {
                    left.insertHelper(value, index, numSmallerAtInsertionTime);
                }
            } else {
                numSmallerAtInsertionTime += leftSubtreeSize;
                if (value > this.value) numSmallerAtInsertionTime++;
                if (right == null) {
                    right = new SpecialBST(value, index, numSmallerAtInsertionTime);
                } else {
                    right.insertHelper(value, index, numSmallerAtInsertionTime);
                }
            }
        }
    }
}
