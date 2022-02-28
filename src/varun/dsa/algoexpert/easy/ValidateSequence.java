package varun.dsa.algoexpert.easy;

/**
 * Validate Subsequence
 * Given two non-empty arrays of integers, write a function that determines
 * whether the second array is a subsequence of the first one.
 * <p>
 * A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the
 * same order as they appear in the array. For instance, the numbers [1, 3, 4] form a subsequence of the
 * array [1, 2, 3, 4] , and so do the numbers [2, 4] . Note that a single number in an array and the array itself are
 * both valid subsequences of the array.
 * <p>
 * Sample Input: [5,1,22,25,6,-1,8,10]
 * Sequence: [1,6,-1,10]
 * <p>
 * Sample Output: true
 * <p>
 * Complexity:
 * O(n) -> Time Complexity
 * O(1) -> Space Complexity
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Validate%20Subsequence
 */
public class ValidateSequence {

    public static void main(String[] args) {
        int[] input = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = new int[]{1, 6, -1, 10};

        System.out.println("Initialising...");
        boolean result = isValidSequence(input, sequence);
        System.out.println("Result: " + result);
    }

    private static boolean isValidSequence(int[] input, int[] sequence) {
        int subCounter = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] == sequence[subCounter]) {
                subCounter++;
            }
        }
        return subCounter == sequence.length;
    }
}
