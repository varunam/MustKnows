package algorithms.searching;

import java.util.Random;
import java.util.Scanner;

/**
 * details: https://www.geeksforgeeks.org/binary-search/
 */
public class BinarySearch {
    public static void main(String[] args) {

        System.out.println("Linear Search Algorithm");
        System.out.println("Generating random array of size 10 with values from 1 to 100");
        int[] array = generateRandomArray(10);
        printArray(array);
        Scanner scanner = new Scanner(System.in);
        int[] sortedArray = bubbleSort(array);
        System.out.println("Random array generated.\nPlease enter a value to be searched\n");
        int findNumber = scanner.nextInt();
        boolean findKey = binarySearch(sortedArray, findNumber);
        System.out.println("\nFound number: " + findKey);
    }

    private static void printArray(int[] array) {
        for (int anArray : array) System.out.print(anArray + " ");
        System.out.println("");
    }

    /**
     * array will be sorted first and then split into two and checked with middle value
     *
     * @param sortedArray - array
     * @param findNumber  - key to be searched
     * @return - boolean whether number is found or not
     */
    private static boolean binarySearch(int[] sortedArray, int findNumber) {
        int l = 0;
        int r = sortedArray.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (sortedArray[m] == findNumber) {
                return true;
            }

            if (sortedArray[m] < findNumber) {
                l = m + 1;
            } else
                r = m - 1;
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

    private static int[] bubbleSort(int[] a) {
        System.out.println("Bubble sorting the array");
        int length = a.length;
        for (int j = 0; j < length; j++) {
            int flag = 0;
            for (int i = 0; i < length - j - 1; i++) {
                if (a[i + 1] < a[i]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    flag = 1;
                    printArray(a);
                }
            }
            if (flag == 0) {
                System.out.println("Sorted already. stopping loop at idex " + j);
                break;
            }
        }

        return a;
    }
}
