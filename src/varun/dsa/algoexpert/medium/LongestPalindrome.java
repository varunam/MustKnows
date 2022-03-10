package varun.dsa.algoexpert.medium;

/**
 * Longest Palindromic Substring
 * Write a function that, given a string, returns its longest palindromic substring
 * A palindrome is defined as a string that's written the same forward and backward. Note that single-character strings are palindromes.
 * You can assume that there will only be one longest palindromic substring.
 * <p>
 * Sample Input
 * string = "abaxyzzyxf"
 * Sample Output
 * "xyzzyx"
 * <p>
 * Time Complexity -> O(n2)
 * Space Complexity -> O(n)
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Longest%20Palindromic%20Substring
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String input = "12abcba21abdeedcba";//"abaxyzzyxf";
        System.out.println("<-- Input -->");
        System.out.println("String: " + input);
        String longestPalindrome = findLongestPalindrome(input);
        System.out.println("<-- Output -->");
        System.out.println("Longest Palindrome: " + longestPalindrome);
    }

    public static String findLongestPalindrome(String str) {
        int[] longestPalindrome = new int[]{0, 0};
        for (int i = 0; i < str.length(); i++) {
            //get a palindrome with current indexed letter as center of the palindrome. Happens with odd length string.
            int[] odd = getLongestPalindrome(str, i - 1, i + 1);
            //get a palindrome with current indexed letter as next to center. Center exists between current and previous letter and happens with even length string.
            int[] even = getLongestPalindrome(str, i - 1, i);
            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longestPalindrome = longestPalindrome[1] - longestPalindrome[0] > longest[1] - longest[0] ? longestPalindrome : longest;
        }
        return str.substring(longestPalindrome[0], longestPalindrome[1]);
    }

    public static int[] getLongestPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }
}
