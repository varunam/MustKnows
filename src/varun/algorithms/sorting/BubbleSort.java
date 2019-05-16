package varun.algorithms.sorting;

/**
 * video explanation: https://youtu.be/Jdtq5uKz-w4?list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 4, 1, 3, 5};
        printArray(a);
        int[] sortedArray = bubbleSort(a);
        System.out.println("Sorting completed");
        printArray(sortedArray);
    }

    private static void printArray(int[] array) {
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println("");
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
