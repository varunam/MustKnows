package varun.problemsolving.arrays;

public class ArrayRotation {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int rotation = 3;

        int[] rotatedArray = rotateArraySimplest(array, rotation);
        for (int i = 0; i < rotatedArray.length; i++) {
            System.out.print(rotatedArray[i] + " ");
        }
    }

    private static int[] rotateArray(int[] array, int rotation) {

        int[] tempArray = new int[array.length];
        rotation = rotation % array.length;
        int j = 0;
        for (int i = rotation; i < array.length; i++) {
            tempArray[j] = array[i];
            j++;
        }
        for (int i = 0; i < rotation; i++) {
            tempArray[j] = array[i];
            j++;
        }
        return tempArray;
    }

    private static int[] rotateArraySimplest(int[] array, int rotation) {
        rotation = rotation % array.length;

        int[] tempArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[(i + rotation) % array.length];
        }

        return  tempArray;
    }
}
