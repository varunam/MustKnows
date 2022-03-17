package varun.dsa.algoexpert.hard;

import varun.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Four Number Sum
 * <p>
 * Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
 * The function should find all! quadruplets in the array that sum up to the target sum and return a two-dimensional
 * array of all these quadruplets in no particular order.
 * If no four numbers sum up to the target sum, the function should return an empty array
 * <p>
 * Sample Input
 * array = 17, 6, 4, -1, 1, 2]
 * targetSum = 16
 * Sample Output
 * [[7, 6, 4, -1), 17, 6, 1, 2]] // the quadruplets could be ordered differently
 * <p>
 * Time Complexity: Average - O(n2), Worst - O(n3)
 * Space Complexity: O(n2) because mostly we will end up storing all sums in hashmap which is n2 pairs.
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Four%20Number%20Sum
 */
public class FourNumberSum {

    public static void main(String[] args) {
        int[] input = new int[]{7, 6, 4, -1, 1, 2};
        int targetSum = 16;
        List<Integer[]> result = fourNumberSum(input, targetSum);
        for (Integer[] value : result) {
            Utils.print(value);
        }
    }

    /*Run through entire array once and inside that loop, first create sum and see if it's there in the map already
     * If not, ignore and move on. After this loop inside the main loop, loop through the items before, create a sum
     * and append them to the map if it's already there. If the pair is not there, add the sum.*/
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer[]>> map = new HashMap<>();
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                int diff = targetSum - sum;
                if (map.containsKey(diff)) {
                    for (Integer[] pair : map.get(diff)) {
                        Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
                        result.add(newQuadruplet);
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int sum = array[i] + array[k];
                Integer[] pair = new Integer[]{array[i], array[k]};
                if (!map.containsKey(sum)) {
                    List<Integer[]> pairGroup = new ArrayList<>();
                    pairGroup.add(pair);
                    map.put(sum, pairGroup);
                } else {
                    map.get(sum).add(pair);
                }
            }
        }
        return result;
    }
}
