package varun.algorithms;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println("Find whether the given number is prime or not");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to find if it's prime or not");
        int number = scanner.nextInt();
        boolean numberPrime = isTheNumberPrime(number);
        System.out.println("prime: " + numberPrime);
    }

    private static boolean isTheNumberPrime(int number) {

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                System.out.println("Divisible by " + i);
                return false;
            }
        }

        return true;
    }
}
