package varun.algorithms.sorting;

/**
 * video explanation: https://youtu.be/TzeBrDU-JaY?list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{12, 11, 13, 5, 6, 7};
        printArray(a);
        int[] sortedArray = mergeSort(a);
        System.out.println("Sorting completed");
        printArray(sortedArray);
    }

    private static void printArray(int[] array) {
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println("");
    }

    private static int[] mergeSort(int[] a) {
        int length = a.length;
        int leftLength = a.length / 2;
        int[] leftArray = new int[leftLength];
        int rightLength = length - leftArray.length;
        int[] rightArray = new int[rightLength];

        if (length < 2)
            return a;

        System.arraycopy(a, 0, leftArray, 0, leftLength);
        System.arraycopy(a, leftLength, rightArray, 0, rightLength);

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        System.out.println("LeftArray");
        printArray(leftArray);
        System.out.println("RightArray");
        printArray(rightArray);

        int[] mergedArray = mergeArray(leftArray, rightArray);
        System.out.println("Merged array");

        printArray(mergedArray);
        return mergedArray;
    }

    private static int[] mergeArray(int[] leftArray, int[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int mergedArray[] = new int[leftLength + rightLength];
        //i to track smallest unpicked element in left array
        int i = 0;
        //j to track smallest unpicked element in right array
        int j = 0;
        //l to track position to be filled in new merged array
        int k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] < rightArray[j]) {
                mergedArray[k] = leftArray[i];
                i++;
            } else {
                mergedArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            mergedArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            mergedArray[k] = rightArray[j];
            j++;
            k++;
        }

        return mergedArray;
    }
}
