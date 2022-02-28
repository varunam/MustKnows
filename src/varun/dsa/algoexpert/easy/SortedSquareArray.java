package varun.dsa.algoexpert.easy;

import varun.Utils;

/**
 * Sorted Squared Array Write a function that takes in a non-empty array of integers that are sorted in ascending order
 * and returns a new array of the same length with the squares of the original integers also sorted in ascending order.
 * <p>
 * Sample Input: [1,2,3,4,5,6,8,9]
 * Sample Output: [1,4,9,6,25,36,64,81]
 * <p>
 * Note: Numbers can be negative too!!
 * <p>
 * Sample Input 2: [-7,-6,-3,4,6]
 * Sample Output 2: [9, 16, 36, 36, 49]
 * <p>
 * Complexity:
 * O(n) -> Time Complexity
 * O(n) -> Space Complexity
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Sorted%20Squared%20Array
 */
public class SortedSquareArray {

    public static void main(String[] args) {
        //int[] input = new int[]{-7, -6, -3, 4, 6};
        int[] input = new int[]{-17, -16, 0, 2, 16};
        System.out.println("<--Input-->");
        Utils.printArray(input);
        int[] result = getSortedSquareArray(input);
        System.out.println("<--Output-->");
        Utils.printArray(result);
    }

    private static int[] getSortedSquareArray(int[] input) {
        int left = 0;
        int right = input.length - 1;
        int index = input.length - 1;
        int[] result = new int[input.length];
        while (left < right) {
            if (Math.abs(input[left]) > Math.abs(input[right])) {
                result[index] = input[left] * input[left];
                left++;
            } else {
                result[index] = input[right] * input[right];
                right--;
            }
            index--;
        }
        return result;
    }
}
