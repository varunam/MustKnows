package varun.dsa.algoexpert.medium;

import varun.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * Write a function that takes in an array of unique integers and returns an array of all
 * permutations of those integers in no particular order.
 * If the input array is empty, the function should return an empty array.
 *
 * Sample Input
 * array = [1, 2, 3]
 * Sample Output
 * [ [1, 2, 3] [1, 3, 2] [2, 1, 3] [2, 3, 1] [3, 2, 1] [3, 1, 2] ]
 *
 * Time Complexity: O(n*n!)
 * Space Complexity: O(n*n!)
 *
 * Problem Link: https://www.algoexpert.io/questions/Permutations
 *
 */
public class Permutations {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println("<--Input-->");
        Utils.print(array);
        System.out.println("<--Output-->");
        List<List<Integer>> result = getPermutations(array);
        Utils.print(result);
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> perms = new ArrayList<>();
        getPermutations(0, array, perms);
        return perms;
    }

    public static void getPermutations(int i, List<Integer> array, List<List<Integer>> perms) {
        if (i == array.size() - 1) {
            perms.add(new ArrayList<Integer>(array));
        } else {
            for (int j = i; j < array.size(); j++) {
                swap(array, i, j);
                getPermutations(i + 1, array, perms);
                swap(array, i, j);
            }
        }
    }

    public static void swap(List<Integer> array, int i, int j) {
        Integer temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
