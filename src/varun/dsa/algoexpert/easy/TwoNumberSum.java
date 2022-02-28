package varun.dsa.algoexpert.easy;

import varun.Utils;

import java.util.HashMap;

/**
 * Two Number Sum
 * Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. If any two numbers in the input array sum up to the target sum, the function should return them in an array, in any order. If no two numbers sum up to the target sum, the function should return an empty array.
 * Note that the target sum has to be obtained by summing two different integers in the array: you can't add a single integer to itself in order to obtain the target sum.
 * You can assume that there will be at most one pair of numbers summing up to the target sum.
 * <p>
 * Sample Input:
 * array = [3, 5, -4, 8, 11, 1, -1, 6]
 * targetSum = 10
 * <p>
 * Sample Output: [-1, 11]
 * The numbers could be in reverse order
 *
 * Complexity:
 * O(n) -> Time Complexity
 * O(n) -> Memory Complexity
 *
 * Link to the problem: https://www.algoexpert.io/questions/Two%20Number%20Sum
 */
public class TwoNumberSum {

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;

        System.out.println("Initialising...");
        int[] result = getTargetSum(array, targetSum);
        System.out.println("Printing result...");
        Utils.print(result);
    }

    private static int[] getTargetSum(int[] array, int targetSum) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int compliment = targetSum - array[i];
            if(resultMap.containsKey(compliment)) {
                return new int[]{compliment, array[i]};
            }
            resultMap.put(array[i], i);
        }
        return new int[0];
    }
}
