package problemsolving;

import java.util.Scanner;

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

    private static int[] printResultRecursive(int[] array, int index, int carrry) {
        if (index + 1 == 0 && carrry != 1) {
            return array;
        } else if (index + 1 == 0) {
            int[] newArray = new int[array.length + 1];
            newArray[0] = 1;
            printArray(newArray);
            return newArray;
        }
        array[index] = array[index] + carrry;
        if (array[index] == 10)
            carrry = 1;
        else
            carrry = 0;
        array[index] = array[index] % 10;
        array = printResultRecursive(array, index - 1, carrry);
        return array;
    }
}
