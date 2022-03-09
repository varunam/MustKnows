package varun;

import java.util.List;

public class Utils {

    public static void print(int[] array) {

        System.out.print("[ ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }

    public static void print(String[] array) {

        System.out.print("[ ");
        for (String value : array) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }

    public static void print(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    public static void print(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    public static void print(List<Integer> branchSums) {
        System.out.print("[ ");
        for(Integer value: branchSums) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }
}
