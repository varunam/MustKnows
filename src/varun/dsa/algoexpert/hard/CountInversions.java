package varun.dsa.algoexpert.hard;

import varun.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Count Inversions
 * Write a function that takes in an array of integers and returns the number of inversions in the array. An inversion
 * occurs if for any valid indices i and j.i<j and array[i] > array[j] .
 * For example, given array = [3, 4, 1, 2] , there are 4 inversions. The following pairs of indices represent
 * inversions: [0, 2], [0, 3], [1, 2], [1, 3] .
 * <p>
 * Intuitively, the number of inversions is a measure of how unsorted the array is.
 * <p>
 * Sample Input: [2,3,3,1,9,5,6]
 * Sample Output: 5
 * //the following pairs of indices represent inversions.
 * //[0,3][1,3][2,3][4,5][4,6]
 * <p>
 * Time Complexity: O(nlongn)
 * Space Complexity: O(n)
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Count%20Inversions
 */
public class CountInversions {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 3, 1, 9, 5, 6};
        System.out.println("<-- Input -->");
        Utils.print(array);
        int result = countSubArrayInversions(array, 0, array.length);
        System.out.println("<-- Output -->");
        System.out.println("Total inversions: " + result);
    }

    public static int countSubArrayInversions(int[] array, int start, int end) {
        if (end - start <= 1) {
            return 0;
        }

        int middle = start + (end - start) / 2;
        int leftInv = countSubArrayInversions(array, start, middle);
        int rightInv = countSubArrayInversions(array, middle, end);
        int mergedArrayInv = mergeSortCountInversions(array, start, middle, end);
        return leftInv + rightInv + mergedArrayInv;
    }

    public static int mergeSortCountInversions(int[] array, int start, int middle, int end) {
        List<Integer> sortedArray = new ArrayList<>();
        int left = start;
        int right = middle;
        int inversions = 0;

        while (left < middle & right < end) {
            if (array[left] <= array[right]) {
                sortedArray.add(array[left]);
                left++;
            } else {
                inversions = inversions + (middle - left);
                sortedArray.add(array[right]);
                right++;
            }
        }

        for (int i = left; i < middle; i++) {
            sortedArray.add(array[i]);
        }

        for (int i = right; i < end; i++) {
            sortedArray.add(array[i]);
        }

        for (int i = 0; i < sortedArray.size(); i++) {
            int num = sortedArray.get(i);
            array[start + i] = num;
        }

        return inversions;
    }

    //O(n2) solution. Brute force.
    public static int countInversions(int[] array) {
        int inversions = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }
}
