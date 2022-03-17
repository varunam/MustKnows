package varun.dsa.algoexpert.medium;

/**
 * Levenshtein Distance
 * Write a function that takes in two strings and returns the minimum number of edit operations that need to be
 * performed on the first string to obtain the second string.
 * There are three edit operations: insertion of a character, deletion of a character, and substitution of a character
 * for another.
 *
 * Sample Input
 * stri = "abc" str2 = "yabd"
 * Sample Output
 * 2
 * // insert "y";
 * substitute "C" for "d"
 *
 * Time Complexity: O(nm)
 * Space Complexity: O(nm) but this can be even as better as O(min(m,n)) as we are always using only two rows at a time.
 *
 * Problem Link: https://www.algoexpert.io/questions/Levenshtein%20Distance
 */
public class LevenshteinDistance {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";
        int output = levenshteinDistance(str1, str2);
        System.out.println("Output: " + output);
    }

    public static int levenshteinDistance(String str1, String str2) {
        int[][] matrix = new int[str2.length()+1][str1.length()+1];
        for(int i = 0; i <= str2.length(); i++) {
            for(int j = 0; j <= str1.length(); j++) {
                matrix[i][j] = j;
            }
            matrix[i][0] = i;
        }

        for(int i = 1; i <= str2.length(); i++) {
            for(int j = 1; j <= str1.length(); j++) {
                if(str2.charAt(i-1) == str1.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1];
                } else {
                    matrix[i][j] = 1 +
                            Math.min(matrix[i][j-1], Math.min(matrix[i-1][j-1], matrix[i-1][j]));
                }
            }
        }
        return matrix[str2.length()][str1.length()];
    }
}
