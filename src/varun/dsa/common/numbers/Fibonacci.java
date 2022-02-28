package varun.dsa.common.numbers;

import java.util.Scanner;

public class Fibonacci {

    private static int[] F = new int[51];

    public static void main(String[] args) {
        initF();
        System.out.println("Printing fibonacci series till given number");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number till which you want the program to print fibonacci");
        int number = scanner.nextInt();
        //printFibonacci(number);
        long time1 = System.currentTimeMillis();
        System.out.println("Recursive with Memoization: " + getFinobacciWithMemoization(number));
        long time2 = System.currentTimeMillis();
        System.out.println("Recursive without Memoization: " + printFibonacciRecursive(number));
        long time3 = System.currentTimeMillis();
        System.out.println("With DP: " + (time2 - time1));
        System.out.println("Without DP: " + (time3 - time2));
    }

    private static void initF() {
        for (int i = 0; i < F.length; i++) {
            F[i] = -1;
        }
    }

    static long t1 = 0;
    static long t2 = 1;

    /**
     * complexity is O(n). Good method to follow
     *
     * @param number
     */
    private static void printFibonacci(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(t1 + " ");
            long sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }

    /**
     * exponential time complexity. Not recommended. Find out time taken to calculate for value 40 and above to see it!
     * video = https://www.youtube.com/watch?v=pqivnzmSbq4
     * @param number
     * @return
     */
    private static int printFibonacciRecursive(int number) {
        if (number <= 1) {
            return number;
        } else {
            return printFibonacciRecursive(number - 1) + printFibonacciRecursive(number - 2);
        }
    }

    /**
     * recursive with memoization.
     * This is not better than the iterative method but as good as it.
     * video tutorial = https://www.youtube.com/watch?v=UxICsjrdlJA
     */

    private static int getFinobacciWithMemoization(int number) {
        if (number <= 1) {
            return number;
        }
        if (F[number] != -1) {
                return F[number];
        } else {
            F[number] = getFinobacciWithMemoization(number - 1) + getFinobacciWithMemoization(number - 2);
            return F[number];
        }
    }
}
