package algorithms;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("Printing fibonacci series till given number");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number till which you want the program to print fibonacci");
        int number = scanner.nextInt();
        printFibonacci(number);
        //System.out.println(printFibonacciRecursive(number));
    }

    static long t1 = 0;
    static long t2 = 1;

    /**
     * complexity is O(n). Good method to follow
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
     * exponential time complexity. Not recommended.
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
}
