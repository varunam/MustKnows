package varun.dsa.algoexpert.easy;

import varun.Utils;
import varun.sorting.MergeSort;

/**
 * Non-Constructable Change
 * Given an array of positive integers representing the values of coins in your possession, write a function that
 * returns the minimum amount of change the minimum sum of money) that you cannot create. The given coins can have
 * any positive integer value and aren't necessarily unique (i.e., you can have multiple coins of the same value).
 * <p>
 * For example, if you're given coins = [1, 2, 5] , the minimum amount of change that you can't create is 4 .
 * If you're given no coins, the minimum amount of change that you can't create is 1.
 * <p>
 * Sample Input Coins: [5,7,1,1,2,3,22]
 * Output: 20
 *
 * Problem Link: https://www.algoexpert.io/questions/Non-Constructible%20Change
 */
public class NonConstructableChange {

    public static void main(String[] args) {
        int[] input = new int[]{5, 7, 1, 1, 2, 3, 42};
        //int[] input = new int[]{1, 5, 1, 1, 1, 10, 15, 20, 100};
        System.out.println("<--Input-->");
        Utils.print(input);
        int result = getNonConstructableChange(input);
        System.out.println("<--Output-->");
        System.out.println("Non Constructable Change: " + result);
    }

    private static int getNonConstructableChange(int[] input) {
        int[] sortedArray = MergeSort.mergeSort(input);
        int change = 0;
        for (int coin : sortedArray) {
            if (change + 1 < coin) {
                return change + 1;
            }
            change = coin + change;
        }
        return change + 1;
    }
}
