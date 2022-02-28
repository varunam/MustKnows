package varun.dsa.numbers;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        System.out.println("Find factorial of a number");
        System.out.println("Enter a number to find it's factorial...");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        long factorial = findFactorial(number);
        System.out.println("Factorial of " + number + " is " + factorial);

    }

    private static long findFactorial(int number) {
        if (number == 1)
            return 1;

        long factorial = number;
        factorial = factorial * findFactorial(number - 1);

        return factorial;
    }
}
