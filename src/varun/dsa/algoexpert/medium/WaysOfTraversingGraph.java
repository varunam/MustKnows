package varun.dsa.algoexpert.medium;

/**
 * Number Of Ways To Traverse Graph
 * You're given two positive integers representing the width and height of a grid-shaped, rectangular graph.
 * Write a function that returns the number of ways to reach the bottom right corner of the graph when starting at
 * the top left corner. Each move you take must either go down or right. In other words, you can never move up or left in the graph.
 * <p>
 * For example, given the graph illustrated below, with width = 2 and height = 3, there are
 * three ways to reach the bottom right! corner when starting at the top left corner:
 * <p>
 * [X X
 * X X
 * X X]
 * 1. Down, Down, Right
 * 2. Right, Down, Down
 * 3. Down, Right, Down
 * Note: you may assume that width * height >= 2 . In other words, the graph will never be a 1x1 grid.
 * Sample Input:
 * width = 4
 * height = 3
 * <p>
 * Sample Output:
 * 10
 * <p>
 * Time Complexity:
 * Solution1: O(2(n+m)) -> Time Complexity and O(2(n+m)) Space Complexity
 * Solution2: O(nm) -> Time Complexity and O(nm) Space Complexity
 */
public class WaysOfTraversingGraph {

    public static void main(String[] args) {
        /*int width = 4;
        int height = 3;
        System.out.println("<--Input-->");
        System.out.println("Width: " + width + ", height: " + height);
        int result = solutionTwoNumberOfWaysToTraverseGraph(width, height);
        System.out.println("<--Output-->");
        System.out.println("Result: " + result);*/

        printSolutionsWithTime();
    }

    public static void printSolutionsWithTime() {
        long start = System.currentTimeMillis();
        System.out.println("Initiating Solution 1...");
        int result = solutionOneNumberOfWaysToTraverseGraph(20, 16);
        long end = System.currentTimeMillis();
        System.out.println("Total time taken for solution one: " + (end - start) + " milli-seconds and found result: " + result);

        start = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Initiating Solution 2...");
        result = solutionTwoNumberOfWaysToTraverseGraph(20, 16);
        end = System.currentTimeMillis();
        System.out.println("Total time taken for solution two: " + (end - start) + " milli-seconds and found result: " + result);
    }

    /**
     * Time Complexity -> O(2^(n+m))
     * Space Complexity -> O(2^(n+m))
     * Terrible!!
     */
    public static int solutionOneNumberOfWaysToTraverseGraph(int width, int height) {
        if (width == 1 || height == 1) {
            return 1;
        }
        return solutionOneNumberOfWaysToTraverseGraph(width - 1, height) +
                solutionOneNumberOfWaysToTraverseGraph(width, height - 1);
    }

    /**
     * Time Complexity -> O(nm)
     * Space Complexity -> O(nm)
     * Much Better.
     */
    public static int solutionTwoNumberOfWaysToTraverseGraph(int width, int height) {

        int[][] numberOfWays = new int[height + 1][width + 1];

        for (int widthIndex = 1; widthIndex < width + 1; widthIndex++) {
            for (int heightIndex = 1; heightIndex < height + 1; heightIndex++) {
                if (widthIndex == 1 || heightIndex == 1) {
                    numberOfWays[heightIndex][widthIndex] = 1;
                } else {
                    int waysLeft = numberOfWays[heightIndex][widthIndex - 1];
                    int waysUp = numberOfWays[heightIndex - 1][widthIndex];
                    numberOfWays[heightIndex][widthIndex] = waysLeft + waysUp;
                }
            }
        }
        return numberOfWays[height][width];
    }
}
