package algorithms.searching;

import java.util.Random;
import java.util.Scanner;

/**
 * details: https://www.geeksforgeeks.org/linear-search/
 */
public class LinearSearch {

    public static void main(String[] args) {

        System.out.println("Linear Search Algorithm");
        System.out.println("Generating random array of size 10 with values from 1 to 100");
        int[] array = generateRandomArray(10);
        System.out.println("Random array generated.\nPlease enter a value to be searched\n");
        printArray(array);
        Scanner scanner = new Scanner(System.in);
        int findNumber = scanner.nextInt();
        boolean findKey = linearSearch(array, findNumber);
        System.out.println("\nFound number: " + findKey);
    }

    private static void printArray(int[] array) {
        for (int anArray : array) System.out.print(anArray + " ");
        System.out.println("");
    }

    /**
     * each element in the array will be compared with key to be found and result is returned
     * @param array - array
     * @param findNumber - key to be searched
     * @return - boolean whether number is found or not
     */
    private static boolean linearSearch(int[] array, int findNumber) {
        for (int anArray : array) {
            if (anArray == findNumber)
                return true;
        }
        return false;
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int number = random.nextInt(100);
            array[i] = number;
        }
        return array;
    }
}
