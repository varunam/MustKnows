package varun.dsa.common.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * <p>
 * Solution - https://leetcode.com/articles/two-sum/#
 */
public class IndexOfTwoNumbersToTarget {

    public static void main(String[] args) {
        System.out.println("Please input size of the array");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Please enter array values separated by space");
        for (int i = 0; i < size; i++) array[i] = scanner.nextInt();
        System.out.println("Entered array is ");
        printArray(array);

        System.out.println("Enter value of the target");
        int target = scanner.nextInt();
        //printResultArrayBruteForce(array, target);
        //printResultArrayOptimised(array, target);
        printResultArrayBestMethod(array, target);

    }

    /**
     * brute force method
     * Complexity - O(n2)
     *
     * @param array
     * @param target
     */
    private static void printResultArrayBruteForce(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    System.out.println("Result: [" + i + ", " + j + "]");
                    return;
                }
            }
        }
        System.out.println("Couldn't find a pair");
    }

    /**
     * better than brute force
     * Complexity - O(n) but the list is traversed twice
     *
     * @param array
     * @param target
     */
    private static void printResultArrayOptimised(int[] array, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            resultMap.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (resultMap.containsKey(complement) && resultMap.get(complement) != i) {
                System.out.println("Result: [" + i + ", " + resultMap.get(complement) + "]");
                return;
            }
        }
        System.out.println("Couldn't find a value");
    }

    /**
     * best method
     * Complexity - O(n) with list traversed only once
     *
     * @param array
     */
    private static void printResultArrayBestMethod(int[] array, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            resultMap.put(array[i], i);
            if (resultMap.containsKey(complement) && resultMap.get(complement) != i) {
                System.out.println("Result: [" + i + ", " + resultMap.get(complement) + "]");
                return;
            }
        }
        System.out.println("Couldn't find a value");
    }

    private static void printArray(int[] array) {
        for (int i1 : array) {
            System.out.print(i1 + " ");
        }
        System.out.println("");
    }

}
