package varun.dsa.algoexpert.medium;

import varun.Utils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * River Sizes
 * <p>
 * You're given a two-dimensional array (a matrix) of potentially unequal height and width containing only os and 1 s.
 * Each o represents land, and each 1 represents part of a river. A river consists of any number of i s that are either
 * horizontally or vertically adjacent (but not diagonally adjacent). The number of adjacent 1 s forming a river determine its size.
 * Note that a river can twist. In other words, it doesn't have to be a straight vertical line or a straight horizontal
 * line; it can be L-shaped, for example.
 * Write a function that returns an array of the sizes of all rivers represented in the input matrix. The sizes don't
 * need to be in any particular order.
 * <p>
 * <-- Sample Input -->
 * 1 0 0 1 0
 * 1 0 1 0 0
 * 0 0 1 0 1
 * 1 0 1 0 1
 * 1 0 1 1 0
 * <-- Output -->
 * [ 2 1 5 2 2 ]
 * <p>
 * Time Complexity -> O(wh)
 * Space Complexity -> O(wh) where w is the width of the matrix and h is the height of the matrix.
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/River%20Sizes
 */
public class RiverSizes {

    public static void main(String[] args) {

        int[][] input = new int[][]{
                new int[]{1, 0, 0, 1, 0},
                new int[]{1, 0, 1, 0, 0},
                new int[]{0, 0, 1, 0, 1},
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 0, 1, 1, 0}
        };

        System.out.println("<-- Input -->");
        Utils.print(input);
        System.out.println("<-- Output -->");
        ArrayList<Integer> riverSizes = new ArrayList<>();
        calculateRiverSizes(input, riverSizes);
        Utils.print(riverSizes);
    }

    public static void calculateRiverSizes(int[][] matrix, ArrayList<Integer> riverSizes) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 1) {
                    continue;
                }

                findNeighboursAndAdd(matrix, row, col, riverSizes);
            }
        }
    }

    public static void findNeighboursAndAdd(int[][] matrix, int rowValue, int colValue, ArrayList<Integer> riverSizes) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{rowValue, colValue});
        int riverSize = 0;
        while (stack.size() > 0) {
            int[] value = stack.pop();
            int row = value[0];
            int col = value[1];
            riverSize++;
            matrix[row][col] = 2;

            if (row - 1 >= 0 && matrix[row - 1][col] == 1) {
                matrix[row - 1][col] = 2;
                stack.push(new int[]{row - 1, col});
            }

            if (row + 1 < matrix.length && matrix[row + 1][col] == 1) {
                matrix[row + 1][col] = 2;
                stack.push(new int[]{row + 1, col});
            }

            if (col - 1 >= 0 && matrix[row][col - 1] == 1) {
                matrix[row][col - 1] = 2;
                stack.push(new int[]{row, col - 1});
            }

            if (col + 1 < matrix[row].length && matrix[row][col + 1] == 1) {
                matrix[row][col + 1] = 2;
                stack.push(new int[]{row, col + 1});
            }
        }
        riverSizes.add(riverSize);
    }
}
