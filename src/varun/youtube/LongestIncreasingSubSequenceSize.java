package varun.youtube;

/**
 * Watch and understand here: https://www.youtube.com/watch?v=odrfUCS9sQk
 */
public class LongestIncreasingSubSequenceSize {

    public static void main(String[] args) {
        int[] input = new int[]{10, 22, 9, 33, 21, 50, 4, 60, 80, 3};
        int output = getLongestIncreasingSubSequence(input);
        System.out.println("Output: " + output);
    }

    /**
     * O(n2)
     **/
    public static int getLongestIncreasingSubSequence(int[] array) {
        int[] dp = new int[array.length];
        int overallMax = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;

            if (dp[i] > overallMax) {
                overallMax = dp[i];
            }
        }
        return overallMax;
    }
}
