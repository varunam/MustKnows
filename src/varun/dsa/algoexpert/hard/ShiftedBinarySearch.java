package varun.dsa.algoexpert.hard;

import varun.Utils;

/**
 * Shifted Binary Search
 * Write a function that takes in a sorted array of distinct integers as well as a target integer.
 * The caveat is that the integers in the array have been shifted by some amount; in other words, they've been moved
 * to the left or to the right by one or more positions. For example, | [1, 2, 3, 4] might have turned into [3, 4, 1, 2] .
 * The function should use a variation of the Binary Search algorithm to determine if the target integer is contained
 * in the array and should return its index if it is, otherwise -1.
 * If you're unfamiliar with Binary Search, we recommend watching the Conceptual Overview section of the Binary Search
 * question's video! explanation before starting to code.
 * <p>
 * <--Input-->
 * [ 45 65 71 72 73 0 1 21 33 37 ]
 * Target: 33
 * <--Output-->
 * Found result at: 8
 * <p>
 * Time Complexity -> O(logn)
 * Space Complexity -> O(1)
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Shifted%20Binary%20Search
 */
public class ShiftedBinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{45, 65, 71, 72, 73, 0, 1, 21, 33, 37};
        int target = 33;
        System.out.println("<--Input-->");
        Utils.print(array);
        System.out.println("Target: " + target);
        int result = shiftedBinarySearch(array, target);
        System.out.println("<--Output-->");
        System.out.println("Found result at: " + result);
    }

    public static int shiftedBinarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;
        int potentialMatch = array[middle];
        int startNum = array[start];
        int endNum = array[end];

        if (target == potentialMatch) {
            return middle;
        } else if (startNum <= potentialMatch) {
            if (potentialMatch > target && target >= startNum) {
                return binarySearch(array, target, start, middle - 1);
            } else {
                return binarySearch(array, target, middle + 1, end);
            }
        } else {
            if (target > potentialMatch && target <= endNum) {
                return binarySearch(array, target, middle + 1, end);
            } else {
                return binarySearch(array, target, start, middle - 1);
            }
        }
    }
}
