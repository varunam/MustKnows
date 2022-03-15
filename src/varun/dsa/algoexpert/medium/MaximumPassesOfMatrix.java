package varun.dsa.algoexpert.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Minimum Passes of Matrix
 * <p>
 * Write a function that takes in an integer matrix of potentially unequal height and width and returns the minimum
 * number of passes required to convert all negative integers in the matrix to positive integers.
 * A negative integer in the matrix can only be converted to a positive integer if one or more of its adjacent elements
 * is positive. An adjacent element is an element that is to the left, to the right, above, or below the current element
 * in the matrix. Converting a negative to a positive simply involves multiplying it by -1.
 * Note that the
 * value is neither positive nor negative, meaning that a
 * can't convert an adjacent negative to a positive,
 * A single pass through the matrix involves converting all the negative integers that can be converted at a particular
 * point in time. For example, consider the following input matrix:
 * [0, -2, -1],
 * [-5, 2, 0],
 * [-6, -2, 0],
 * After a first pass, only 3 values can be converted to positives:
 * [0, 2, -1],
 * [5, 2, 0],
 * [-6, 2, 0],
 * After a second pass, the remaining negative values can all be converted to positives:
 * [0, 2, 1],
 * [5, 2, 0],
 * [6, 2, 0],
 * Note that the input matrix will always contain at least one element. If the negative integers in the input matrix
 * can't all be converted to positives, regardless of how many passes are run, your function should return -1.
 * <p>
 * Time Complexity: O(w*h)
 * Space Complexity: O(w*h)
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Minimum%20Passes%20Of%20Matrix
 */
public class MaximumPassesOfMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{0, -2, -1},
                new int[]{-5, 2, 0},
                new int[]{-6, -2, 0}
        };
        int result = minimumPassesOfMatrix(matrix);
        System.out.println("Output: " + result);
    }

    public static int minimumPassesOfMatrix(int[][] matrix) {
        int passes = convertNegatives(matrix);
        return !containsNegative(matrix) ? passes - 1 : -1;
    }

    public static int convertNegatives(int[][] matrix) {
        Queue<int[]> queue = getAllPositivePositions(matrix);
        int passes = 0;
        while (queue.size() > 0) {
            int currentSize = queue.size();
            while (currentSize > 0) {
                int[] positivePosition = queue.poll();
                currentSize--;
                int currentRow = positivePosition[0];
                int currentCol = positivePosition[1];

                List<int[]> adjacentPositions = getAdjacentPositions(currentRow, currentCol, matrix);
                for (int[] position : adjacentPositions) {
                    int row = position[0];
                    int col = position[1];
                    matrix[row][col] *= -1;
                    queue.add(position);
                }
            }
            passes++;
        }
        return passes;
    }

    public static List<int[]> getAdjacentPositions(int row, int col, int[][] matrix) {
        List<int[]> adjacentPositions = new ArrayList<>();

        //top
        if (row - 1 >= 0 && matrix[row - 1][col] < 0) {
            adjacentPositions.add(new int[]{row - 1, col});
        }

        //bottom
        if (row + 1 < matrix.length && matrix[row + 1][col] < 0) {
            adjacentPositions.add(new int[]{row + 1, col});
        }

        //left
        if (col - 1 >= 0 && matrix[row][col - 1] < 0) {
            adjacentPositions.add(new int[]{row, col - 1});
        }

        //right
        if (col + 1 < matrix[row].length && matrix[row][col + 1] < 0) {
            adjacentPositions.add(new int[]{row, col + 1});
        }

        return adjacentPositions;
    }

    public static Queue<int[]> getAllPositivePositions(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] > 0) {
                    queue.add(new int[]{row, col});
                }
            }
        }
        return queue;
    }

    public static boolean containsNegative(int[][] matrix) {
        for (int[] arrays : matrix) {
            for (int value : arrays) {
                if (value < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
