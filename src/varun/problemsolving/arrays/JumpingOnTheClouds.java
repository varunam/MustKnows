package varun.problemsolving.arrays;

/**
 * Emma is playing a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus or
 * <p>
 * . She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.
 * <p>
 * For each game, Emma will get an array of clouds numbered
 * if they are safe or if they must be avoided. For example, indexed from . The number on each cloud is its index in the list so she must avoid the clouds at indexes and . She could follow the following two paths: or . The first path takes jumps while the second takes
 * <p>
 * .
 * <p>
 * Function Description
 * <p>
 * Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.
 * <p>
 * jumpingOnClouds has the following parameter(s):
 * <p>
 * c: an array of binary integers
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer
 * , the total number of clouds. The second line contains space-separated binary integers describing clouds where
 * <p>
 * .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the minimum number of jumps needed to win the game.
 * <p>
 * Sample Input:
 * 7
 * 0 0 1 0 0 1 0
 * <p>
 * Sample Output:
 * 4
 * <p>
 * Url: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */
public class JumpingOnTheClouds {

    public static void main(String[] args) {

        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0}));
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int steps = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 1) {
                continue;
            }

            if (i + 2 < c.length && c[i + 2] == 0) {
                i++;
                steps++;
            } else if (i + 1 < c.length && c[i + 1] == 0) {
                steps++;
            }
        }
        return steps;
    }
}
