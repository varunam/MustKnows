package algorithms.sorting;

/**
 * video explanation: https://youtu.be/GUDLRan2DWM?list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] a = new int[]{2, 7, 4, 1, 3, 5};
        printArray(a);
        int[] sortedArray = selectionSort(a);
        System.out.println("Sorting completed");
        printArray(sortedArray);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    private static int[] selectionSort(int[] a) {
        System.out.println("Sorting the array");
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                    printArray(a);
                }
            }
        }
        return a;
    }
}
