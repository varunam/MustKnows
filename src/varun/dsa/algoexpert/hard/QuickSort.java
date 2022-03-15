package varun.dsa.algoexpert.hard;

import varun.Utils;

/**
 * Quick Sort
 * ☆
 * Write a function that takes in an array of integers and returns a sorted version of that array.
 * Use the Quick Sort algorithm to sort the array.
 * If you're unfamiliar with Quick Sort, we recommend watching the Conceptual Overview section of this
 * question's video explanation before starting to code.
 * <p>
 * Sample Input
 * array = [8, 5, 2, 9, 5, 6, 3]
 * Sample Output
 * [2, 3, 5, 5, 6, 8, 9]
 * <p>
 * Time Complexity: O(n) average and O(n2) worst case.
 * Space Complexity: O(1)
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Quick%20Sort
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] input = new int[]{8, 5, 2, 9, 5, 6, 3};
        System.out.println("<--Input-->");
        Utils.print(input);
        System.out.println("<--Output-->");
        int[] output = quickSort(input);
        Utils.print(output);
    }

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int pIndex = partition(array, start, end);
        quickSort(array, start, pIndex - 1);
        quickSort(array, pIndex + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (pivot >= array[i]) {
                swap(i, pIndex, array);
                pIndex++;
            }
        }
        swap(pIndex, end, array);
        return pIndex;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
