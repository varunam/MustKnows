package varun;

public class Utils {

    public static void printArray(int[] array) {

        System.out.print("[ ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }

    public static void printArray(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }
}
