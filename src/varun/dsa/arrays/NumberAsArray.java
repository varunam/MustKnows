package varun.dsa.arrays;

import java.util.Scanner;

/**
 * Array is supplied as input and it indicates a number.
 * Ex: If the array supplied is [1, 3, 4], it indicates a number 134.
 * The requirement is to add 1 to the number.
 * So, if the input is [2, 9, 9], output should be [3, 0, 0]
 * similarly,
 * if the input it [9,9,9], output should be [1,0,0,0]
 */
public class NumberAsArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the array you want to enter");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter " + size + " elements to the array");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Entered array is ");
        printArray(array);
        System.out.println("\nCalculating result...");
        int[] result = printResultRecursive(array, array.length - 1, 1);
        printArray(result);
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.print("]");
    }

    private static void printResult(int[] array) {
        int[] newArray = new int[array.length];
        int carry = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[i] = array[i] + carry;
            if (newArray[i] != 10) {
                carry = 0;
            }
            newArray[i] = newArray[i] % 10;
        }
        if (carry == 1) {
            newArray = new int[array.length + 1];
            newArray[0] = 1;
        }
        printArray(newArray);
    }

    private static int[] printResultRecursive(int[] array, int index, int carry) {
        if (index + 1 == 0 && carry != 1) {
            return array;
        } else if (index + 1 == 0) {
            int[] newArray = new int[array.length + 1];
            newArray[0] = 1;
            printArray(newArray);
            return newArray;
        }
        array[index] = array[index] + carry;
        if (array[index] == 10)
            carry = 1;
        else
            carry = 0;
        array[index] = array[index] % 10;
        array = printResultRecursive(array, index - 1, carry);
        return array;
    }
}
