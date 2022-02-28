package arun.upgrad;

import java.util.Scanner;

public class PatternRecursion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        pattern(n);
    }

    public static void pattern(int n) {
        if (n > 0) {
            pattern(n - 1);
        }
        printPattern(n);
        System.out.print("\n");
    }

    public static void printPattern(int n) {
        if (n > 0) {
            System.out.print("*");
            printPattern(n - 1);
        }
    }
}

