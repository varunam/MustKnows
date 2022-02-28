package arun.upgrad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitionPositiveNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        partitionNegativeAndPositive(n, arr);
    }

    // Method to partition negative and positive numbers without comparing with 0
    static void partitionNegativeAndPositive(int n, int arr[]) {
        List<Integer> positiveNums = new ArrayList<Integer>();
        List<Integer> negativeNums = new ArrayList<Integer>();
        for (int item : arr) {
            if (getSign(item).equals("positive")) {
                positiveNums.add(item);
            } else {
                negativeNums.add(item);
            }
        }

        if (positiveNums.size() == arr.length) {
            printArrayList(positiveNums);
            System.out.println();
            System.out.println("Array doesn't have negative numbers");
        } else if (negativeNums.size() == arr.length) {
            printArrayList(negativeNums);
            System.out.println();
            System.out.println("Array doesn't have negative numbers");
        } else if (arr[0] >= 0) {
            printArrayList(positiveNums);
            System.out.println();
            printArrayList(negativeNums);
        } else {
            printArrayList(negativeNums);
            System.out.println();
            printArrayList(positiveNums);
        }
    }

    static String getSign(int number) {
        int x = (int) Math.sqrt(Math.pow(number, 2));
        try {
            x = number / x;
        } catch (ArithmeticException e) {
            x = 1;
        }
        String[] result = {"negative", "", "positive"};
        return result[x + 1];
    }

    static void printArrayList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
