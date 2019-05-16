package varun.problemsolving.string;

import java.util.Scanner;

public class StringPermutations {

    static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to print it's permutations");
        String input = scanner.nextLine();

        printPermutaions(input, 0, input.length() - 1);
        System.out.println("Total combinations found: " + count);
    }

    private static void printPermutaions(String input, int start, int end) {
        if (start == end) {
            {
                count++;
                System.out.println(input);
            }
        } else {
            for (int i = start; i <= end; i++) {
                input = swap(input, start, i);
                printPermutaions(input, start + 1, end);
                input = swap(input, start, i);
            }
        }
    }

    private static String swap(String input, int x, int y) {
        char[] array = input.toCharArray();
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
        return String.valueOf(array);
    }

}
