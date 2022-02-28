package varun.dsa.common.string;

import java.util.Scanner;

/**
 * Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
 * (eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
 */
public class StringRoundRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String 1");
        String string1 = scanner.nextLine();
        System.out.println("Enter String 2");
        String string2 = scanner.nextLine();

        System.out.println("String 2 is round rotation of String 1: " + isRoundRotation(string1, string2));
    }

    private static boolean isRoundRotation(String string1, String string2) {
        String newString = string1 + string1;
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
        return string1.length() == string2.length() &&
                newString.contains(string2);
    }
}
