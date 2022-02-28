package varun.dsa.string;

public class PalindromeStringWithoutBuilder {
    public static void main(String[] args) {
        String string = "malayalam";
        boolean palindrome = isStringPalindrome(string);
        System.out.println(string + " is palindrome? " + palindrome);
    }

    private static boolean isStringPalindrome(String string) {
        return isStringPalindrome(string, 0, string.length() - 1);
    }

    private static boolean isStringPalindrome(String string, int start, int end) {

        System.out.println("Checking for \'" + string.substring(start, end + 1) + "\'");

        if (start == end)
            return true;

        if (string.charAt(start) != string.charAt(end))
            return false;

        if (start < end + 1) {
            return isStringPalindrome(string, start + 1, end - 1);
        }

        return true;
    }
}
