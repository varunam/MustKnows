package problemsolving.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindSocksPairs {

    public static void main(String[] args) {
        System.out.println("Please input size of the array");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Please enter array values separated by space");
        for (int i = 0; i < size; i++) array[i] = scanner.nextInt();
        System.out.println("Entered array is ");
        printArray(array);

        System.out.println("Calculating pairs");
        int result = calculatePairs(array);
        System.out.println("Result is " + result);
    }

    private static int calculatePairs(int[] array) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        int pairsCounter = 0;
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (resultMap.containsKey(value)) {
                pairsCounter++;
                System.out.println(resultMap.remove(value));
            } else {
                resultMap.put(value, value);
            }
        }
        System.out.println(resultMap.values());
        return pairsCounter;
    }

    private static void printArray(int[] array) {
        for (int i1 : array) {
            System.out.print(i1 + " ");
        }
        System.out.println("");
    }
}
