package varun.dsa.algoexpert.hard;

import varun.Utils;

/**
 * Quickselect
 * Write a function that takes in an array of distinct integers as well as an integer k and that returns the
 * kth smallest integer in that array.
 * The function should do this in linear time, on average,
 * Sample Input
 * array = [8, 5, 2, 9, 7, 6, 3] k = 3
 * Sample Output: 5
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Quickselect
 */
public class QuickSelect {

    public static void main(String[] args) {
        int[] input = new int[]{8, 5, 2, 9, 7, 6, 3};
        int k = 3;
        System.out.println("<--Input-->");
        Utils.print(input);
        System.out.println("K=" + k);
        int result = quickSelect(input, k);
        System.out.println("<--Output-->");
        System.out.println("Result: " + result);
    }

    public static int quickSelect(int[] array, int k) {
        return quickSelect(array, k - 1, 0, array.length - 1);
    }

    public static int quickSelect(int[] array, int k, int start, int end) {
        int partition = partition(array, start, end);

        if (k == partition) {
            return array[partition];
        } else if (k > partition) {
            return quickSelect(array, k, partition + 1, end);
        } else {
            return quickSelect(array, k, start, partition - 1);
        }
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (pivot >= array[i]) {
                swap(pIndex, i, array);
                pIndex++;
            }
        }
        swap(end, pIndex, array);
        return pIndex;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
