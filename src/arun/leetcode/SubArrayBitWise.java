package arun.leetcode;

import java.util.HashSet;
import java.util.Set;

import static arun.leetcode.UtilKt.generateRandomArray;
import static arun.leetcode.UtilKt.printArray;

/**
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/
 */
public class SubArrayBitWise {
    public static void main(String[] args) {
        int[] array = generateRandomArray(4, 5);
        printArray(array);
        System.out.println("Number of unique bitwise ORs");
        System.out.println(subArrayBitwiseORs(array));
    }

    private static int subArrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                // Not sure why is this needed?
                if ((arr[j] | arr[i]) == arr[j]) {
                    break;
                }
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
            printArray(arr);
            System.out.println();
        }
        return set.size();
    }
}
