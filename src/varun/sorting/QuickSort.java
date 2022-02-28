package varun.sorting;

/**
 * video explanation: https://youtu.be/COk73cpQbFQ?list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 4, 1, 3, 5};
        printArray(a);
        int[] sortedArray = quickSort(a, 0, a.length-1);
        System.out.println("Sorting completed");
        printArray(sortedArray);
    }

    private static void printArray(int[] array) {
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println("");
    }

    private static int[] quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pIndex = getPartitionIndex(a, start, end);
            quickSort(a, start, pIndex - 1);
            quickSort(a, pIndex + 1, end);
        }
        return a;
    }

    private static int getPartitionIndex(int[] array, int start, int end) {

        int pivot = array[end];
        int partitionIndex = start;
        for (int i = 0; i < end; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[partitionIndex];
                array[partitionIndex] = temp;
                partitionIndex++;
            }
        }
        int temp = array[end];
        array[end] = array[partitionIndex];
        array[partitionIndex] = temp;
        return partitionIndex;
    }
}
