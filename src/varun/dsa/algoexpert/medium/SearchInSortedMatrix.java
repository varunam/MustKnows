package varun.dsa.algoexpert.medium;

import varun.Utils;

/**
 * Search In Sorted Matrix
 * You're given a two-dimensional array (a matrix) of distinct integers and a target integer. Each row in the matrix
 * is sorted, and each column is also sorted; the matrix doesn't necessarily have the same height and width.
 * Write a function that returns an array of the row and column indices of the target integer if it's contained
 * in the matrix, otherwise
 * [-1, -1].
 * Sample Input
 * matrix = [
 * [1, 4, 7, 12, 15, 1000],
 * [2, 5, 19, 31, 32, 1001],
 * [3, 8, 24, 33, 35, 1002],
 * [40, 41, 42, 44, 45, 1003],
 * [99, 100, 103, 106, 128, 1004],
 * ]
 * target = 44
 *
 * Sample Output:
 * [ 3, 3 ]
 *
 * Time Complexity: O(n+m) where n is length of matrix and m is length of matrix's columns length;
 * Space Complexity: O(1)
 *
 * Problem Link: https://www.algoexpert.io/questions/Search%20In%20Sorted%20Matrix
 */
public class SearchInSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{1, 4, 7, 12, 15, 1000},
                new int[]{2, 5, 19, 31, 32, 1001},
                new int[]{3, 8, 24, 33, 35, 1002},
                new int[]{40, 41, 42, 44, 45, 1003},
                new int[]{99, 100, 103, 106, 128, 1004},
        };
        int target = 44;
        System.out.println("<--Input-->");
        Utils.print(matrix);
        System.out.println("Target: " + target);
        System.out.println("<--Output-->");
        int[] result = searchInSortedMatrix(matrix, target);
        Utils.print(result);
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int count = 0;
        for(int row = 0; row<matrix.length; row++) {
            for(int col = matrix[row].length-1; col>=0; col--) {
                count++;
                if(matrix[row][col] < target) {
                    break;
                }
                if(matrix[row][col]==target) {
                    System.out.println("Run total times: " + count);
                    return new int[]{row, col};
                }
            }
        }
        System.out.println("Run total times: " + count);
        return new int[] {-1, -1};
    }
}
