package varun.dsa.algoexpert.medium;

import java.util.Arrays;

/**
 * Min Number Of Coins For Change
 * Given an array of positive integers representing coin denominations and a single non-negative integer n representing
 * a target amount of money, write a function that returns the smallest number of coins needed to make change for
 * (to sum up to) that target amount using! the given coin denominations.
 * Note that you have access to an unlimited amount of coins. In other words, if the denominations are [1, 5, 10] ,
 * you have access to an unlimited amount of 1 s, 5 s, and 10 s.
 *
 * If it's impossible to make change for the target amount, return -1 .
 *
 * Sample Input:
 * denoms = [ 1, 5, 10]
 * Output = 3 //1x2 + 5x1
 *
 * Time Complexity: O[nd]
 * Space Complexity: O[n]
 */
public class MinimumCoinsForChange {

    public static void main(String[] args) {
        int[] denoms = new int[]{10,5,1};
        int dollarValue = 3;
        System.out.println("<--Input-->");
        System.out.println("Dollar Value: " + dollarValue);
        int result = minNumberOfCoinsForChange(dollarValue, denoms);
        System.out.println("<--Output-->");
        System.out.println("Minimum number of coins: " + result);
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] numberOfCoins = new int[n + 1];
        Arrays.fill(numberOfCoins, Integer.MAX_VALUE);
        int minimumCoins = 0;
        numberOfCoins[0] = 0;
        for (int denom : denoms) {
            for (int amount = 0; amount < numberOfCoins.length; amount++) {
                if(amount >= denom) {
                    if(numberOfCoins[amount - denom] == Integer.MAX_VALUE) {
                        minimumCoins = numberOfCoins[amount - denom];
                    } else {
                        minimumCoins = numberOfCoins[amount - denom] + 1;
                    }
                    numberOfCoins[amount] = Math.min(minimumCoins, numberOfCoins[amount]);
                }
            }
        }
        return numberOfCoins[n] == Integer.MAX_VALUE ? -1 : numberOfCoins[n];
    }
}
