package varun.dsa.algoexpert.hard;

import java.util.Stack;

/**
 * Interweaving Strings
 * Write a function that takes in three strings and returns a boolean representing whether the third string can be
 * formed by interweaving! the first two strings.
 * To interweave strings means to merge them by alternating their letters without any specific pattern. For instance,
 * the strings "abc" and "123" can be interwoven as "alb2c3" , as "abc123" , and as "ablc23" (this list is nonexhaustive).
 * Letters within a string must maintain their relative ordering in the interwoven string.
 * <p>
 * Sample Input
 * one = "algoexpert" two = "your-dream-job" three = "your-algodream-expertjob".
 * Sample Output
 * true
 * <p>
 * Time Complexity: O(x+y+z) where x is the length of first string, y is the length of second string and z is third.
 * Space Complexity: O(x+y)
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Interweaving%20Strings
 */
public class InterweavingString {

    public static void main(String[] args) {
        /*String one = "algoexpert";
        String two = "your-dream-job";
        String three = "your-algodream-expertjob";*/
        String one = "algo";
        String three = "fralgogo";
        String two = "frog";
        boolean interweaving = interweavingStrings(one, two, three);
        System.out.println("Output: " + interweaving);

        //Not so the best solution as it doesn't verify the order of occurance.
        //boolean result = getStringSum(one) + getStringSum(two) == getStringSum(three);
    }

    /**
     * Best Solution
     **/
    public static boolean interweavingStrings(String one, String two, String three) {
        Stack<Character> stackOne = getStackFromString(one);
        Stack<Character> stackTwo = getStackFromString(two);

        char[] threeChars = three.toCharArray();
        for (int i = threeChars.length - 1; i >= 0; i--) {
            char character = threeChars[i];
            if (!stackTwo.isEmpty() && character == stackTwo.peek()) {
                stackTwo.pop();
            } else if (!stackOne.isEmpty() && character == stackOne.peek()) {
                stackOne.pop();
            } else {
                return false;
            }
        }
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }

    public static Stack<Character> getStackFromString(String string) {
        char[] chars = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char character : chars) {
            stack.push(character);
        }
        return stack;
    }

    /**
     * Not so the best solution as this doesn't verify the order of letters occurance
     **/
    public static int getStringSum(String string) {
        char[] chars = string.toCharArray();
        int sum = 0;
        for (char character : chars) {
            sum = sum + character;
        }
        return sum;
    }
}
