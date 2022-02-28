package varun.dsa.arrays;

import java.io.IOException;
import java.util.Scanner;

/**
 * Problem picked from hackerrank. Link here
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */

public class HourGlass2DArray {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int width = arr[0].length;
        int length = arr.length;

        int bottleGlassTotal = Integer.MAX_VALUE;
        for (int i = 0; i < length - 2; i++) {
            for (int j = 0; j < width - 2; j++) {
                int total = arr[j][i] + arr[j][i + 1] + arr[j][i + 2] + arr[j + 1][i + 1] + arr[j + 2][i] + arr[j + 2][i + 1] + arr[j + 2][i + 2];
                if (bottleGlassTotal == Integer.MAX_VALUE)
                    bottleGlassTotal = total;
                if (total > bottleGlassTotal)
                    bottleGlassTotal = total;

                System.out.println("Bottle glass: ");
                System.out.println(arr[i][j] + "" + arr[j][i + 1] + "" + arr[j][i + 2] + "\n " + arr[j + 1][i + 1] + "\n" + arr[j + 2][i] + "" + arr[j + 2][i + 1] + "" + arr[j + 2][i + 2]);
                System.out.println("Total: " + total);
            }
            System.out.println("");
        }
        return bottleGlassTotal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int[][] arr = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}
        };

        int result = hourglassSum(arr);
        System.out.println("Found result: " + result);

        scanner.close();
    }
}

