package varun.dsa.algoexpert.medium;

import varun.Utils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Remove Islands
 *
 * You're given a two-dimensional array (a matrix) of potentially unequal height and width containing only os and 1 s.
 * The matrix represents a two-toned image, where each i represents black and each represents white. An island is defined
 * as any number of 1 s that are horizontally or vertically adjacent (but not diagonally adjacent) and that don't touch
 * the border of the image. In other words, a group of horizontally or vertically adjacent 1 s isn't an island if any
 * of those 1 s are in the first row, last row, first column, or last column of the input matrix.
 * Note that an island can twist. In other words, it doesn't have to be a straight vertical line or a straight horizontal
 * line; it can be L-shaped, for example.
 * You can think of islands as patches of black that don't touch the border of the two-toned image,
 * Write a function that returns a modified version of the input matrix, where all of the islands are removed. You
 * remove an island by replacing it with s.
 * Naturally, you're allowed to mutate the input matrix.
 *
 * <-- Sample Input -->
 * 1 0 0 0 0 0
 * 0 1 0 1 0 1
 * 0 0 1 0 1 0
 * 1 1 0 0 1 0
 * 1 0 1 1 0 0
 * 1 0 0 0 0 1
 * <-- Sample Output -->
 * 1 0 0 0 0 0
 * 0 0 0 0 0 1
 * 0 0 0 0 0 0
 * 1 1 0 0 0 0
 * 1 0 0 0 0 0
 * 1 0 0 0 0 1
 *
 * Time Complexity -> O(wh)
 * Space Complexity -> O(wh) where w is the width of the matrix and h is the height of the matrix.
 *
 * Problem Link: https://www.algoexpert.io/questions/Remove%20Islands
 */
public class RemoveIslands {

    public static void main(String[] args) {
        /*int[][] input = new int[][]{
                new int[]{1, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 1, 1, 1},
                new int[]{0, 0, 1, 0, 1, 0},
                new int[]{1, 1, 0, 0, 1, 0},
                new int[]{1, 0, 1, 1, 0, 0},
                new int[]{1, 0, 0, 0, 0, 1}
        };*/

        int[][] input = new int[][]{
                new int[]{1, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 1, 0, 1},
                new int[]{0, 0, 1, 0, 1, 0},
                new int[]{1, 1, 0, 0, 1, 0},
                new int[]{1, 0, 1, 1, 0, 0},
                new int[]{1, 0, 0, 0, 0, 1}
        };

        System.out.println("<-- Input -->");
        Utils.print(input);
        System.out.println("<-- Output -->");
        int[][] output = removeIslands(input);
        Utils.print(output);
    }

    public static int[][] removeIslands(int[][] input) {
        boolean[][] onesConnectedToBorder = new boolean[input.length][input[0].length];

        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[row].length; col++) {
                boolean rowIsBorder = row == 0 || row == input.length - 1;
                boolean colIsBorder = col == 0 || col == input[row].length - 1;
                boolean isBorder = rowIsBorder || colIsBorder;

                if (!isBorder) {
                    continue;
                }

                if (input[row][col] != 1) {
                    continue;
                }

                findOnesConnectedToBorder(input, row, col, onesConnectedToBorder);
            }
        }

        for (int row = 0; row < onesConnectedToBorder.length; row++) {
            for (int col = 0; col < onesConnectedToBorder[row].length; col++) {
                if (onesConnectedToBorder[row][col]) {
                    continue;
                }
                input[row][col] = 0;
            }
        }
        return input;
    }

    public static void findOnesConnectedToBorder(int[][] input, int row, int col, boolean[][] onesConnectedToBorder) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});

        while (!stack.isEmpty()) {
            int[] currentPosition = stack.pop();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            boolean alreadyVisited = onesConnectedToBorder[currentRow][currentCol];
            if (alreadyVisited) {
                continue;
            }

            onesConnectedToBorder[currentRow][currentCol] = true;

            int[][] neighbours = findNeighbours(input, currentRow, currentCol);
            for (int[] neighbour : neighbours) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];

                if (input[neighbourRow][neighbourCol] != 1) {
                    continue;
                }
                stack.push(neighbour);
            }
        }
    }

    public static int[][] findNeighbours(int[][] input, int row, int col) {
        int numRows = input.length;
        int numCols = input[row].length;

        ArrayList<int[]> temp = new ArrayList<>();

        if (row - 1 >= 0) {
            temp.add(new int[]{row - 1, col}); //UP
        }

        if (row + 1 < numRows) {
            temp.add(new int[]{row + 1, col}); //DOWN
        }

        if (col - 1 >= 0) {
            temp.add(new int[]{row, col - 1}); //LEFT
        }

        if (col + 1 < numCols) {
            temp.add(new int[]{row, col + 1}); //RIGHT
        }

        int[][] neighbours = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            neighbours[i] = temp.get(i);
        }

        return neighbours;
    }
}
