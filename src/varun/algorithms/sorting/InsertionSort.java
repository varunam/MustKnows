package varun.algorithms.sorting;

/**
 * video explanation: https://youtu.be/i-SKeOcBwko?list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 4, 1, 3, 5};
        printArray(a);
        int[] sortedArray = insertionSort(a);
        System.out.println("Sorting completed");
        printArray(sortedArray);
    }

    private static void printArray(int[] array) {
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println("");
    }

    private static int[] insertionSort(int[] a) {
        System.out.println("Insertion sorting the array");
        int length = a.length;
        int value = 0, hole = 0;
        for (int i = 1; i < length; i++) {
            value = a[i];
            hole = i;
            while (hole > 0 && a[hole - 1] > value) {
                a[hole] = a[hole - 1];
                hole = hole - 1;
            }
            a[hole] = value;
        }

        return a;
    }
}
