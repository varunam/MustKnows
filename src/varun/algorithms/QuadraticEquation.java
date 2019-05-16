package varun.algorithms;

import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------- SOLVING QUADRATINC EQUATION -----------");
        System.out.println("Enter value of a");
        double a = scanner.nextDouble();
        System.out.println("Enter value of b");
        double b = scanner.nextDouble();
        System.out.println("Enter value of c");
        double c = scanner.nextDouble();
        System.out.println("Computing values of r1 and r2");

        double r1, r2;

        /**
         * logic to find roots
         *
         * The term b2-4ac is known as the determinant of a quadratic equation. The determinant tells the nature of the roots.
         *
         *     If determinant is greater than 0, the roots are real and different.
         *     If determinant is equal to 0, the roots are real and equal.
         *     If determinant is less than 0, the roots are complex and different.
         */

        //finding determinant
        double d = (b * b) - (4 * a * c);
        System.out.println("\ndeterminant: " + d);

        //roots are real and different
        if (d > 0) {
            r1 = (-b + Math.sqrt(d)) / (2 * a);
            r2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("root1: " + r1 + " root2: " + r2);
        } else
            //roots are real and equal
            if (d == 0) {
                r1 = r2 = -b / (2 * a);
                System.out.println("root1: " + r1 + " root2: " + r2);
            } else {
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-d) / (2 * a);
                System.out.format("root1: %.2f+%.2fi and root2: %.2f-%.2fi", realPart, imaginaryPart, realPart, imaginaryPart);
            }
    }
}
