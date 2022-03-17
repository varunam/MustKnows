package varun.youtube;

import varun.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of numbers in sorted order, count the pairs of numbers whose sum is less than X.
 * Solution: https://www.youtube.com/watch?v=bptRLm3OiV8
 */
public class PairSumLessThanX {

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 6, 8, 9};
        int x = 14;
        int output = getPairSumLessThanX(input, x);
        System.out.println("Output: " + output);

        List<Integer[]> pairs = getPairsSumLessThanX(input, x);
        for (Integer[] pair : pairs) {
            Utils.print(pair);
        }
    }

    private static int getPairSumLessThanX(int[] array, int targetSum) {
        int count = 0;
        int first = 0;
        int last = array.length - 1;
        while (first != last) {
            int sum = array[first] + array[last];
            if (sum < targetSum) {
                count += (last - first);
                first++;
            } else {
                last--;
            }
        }
        return count;
    }

    private static List<Integer[]> getPairsSumLessThanX(int[] array, int targetSum) {
        List<Integer[]> listOfPairs = new ArrayList<>();
        int count = 0;
        int first = 0;
        int last = array.length - 1;
        while (first != last) {
            int sum = array[first] + array[last];
            if (sum < targetSum) {
                for (int i = last; i > first; i--) {
                    listOfPairs.add(new Integer[]{array[first], array[i]});
                }
                first++;
            } else {
                last--;
            }
        }
        return listOfPairs;
    }
}
