package varun.problemsolving.arrays;

import java.util.List;

public class MaxSubSquare {
    public static void main(String[] args) {
        int M[][] = {
                {1, 1, 1,},
                {1, 1, 0,},
                {1, 0, 1}
        };
        int i = largestMatrix(M);
        System.out.println("Result: " + i);
    }

   /* public static int largestMatrix(List<List<Integer>> arr) {
        // Write your code here
        int R = arr.size();
        int C = arr.get(0).size();
        int S[][] = new int[R][C];

        for (int i = 0; i < R; i++) {
            S[i][0] = arr.get(i).get(0);
        }

        for (int j = 0; j < C; j++) {
            S[0][j] = arr.get(0).get(j);
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (arr.get(i).get(j) == 1) {
                    S[i][j] = Math.min(S[i][j - 1], Math.min(S[i - 1][j], S[i - 1][j - 1])) + 1;
                } else {
                    S[i][j] = 0;
                }
            }
        }

        int maxInS = S[0][0], maxI = 0, maxJ = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maxInS < S[i][j]) {
                    maxInS = S[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return maxI;
    }*/

    public static int largestMatrix(int[][] arr) {
        // Write your code here
        int R = arr.length;
        int C = arr[0].length;
        int S[][] = new int[R][C];

        for (int i = 0; i < R; i++) {
            S[i][0] = arr[i][0];
        }

        for (int j = 0; j < C; j++) {
            S[0][j] = arr[0][j];
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (arr[i][j] == 1) {
                    S[i][j] = Math.min(S[i][j - 1], Math.min(S[i - 1][j], S[i - 1][j - 1])) + 1;
                } else {
                    S[i][j] = 0;
                }
            }
        }

        int maxInS = S[0][0], maxI = 0, maxJ = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maxInS < S[i][j]) {
                    maxInS = S[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return maxInS;
    }
}
