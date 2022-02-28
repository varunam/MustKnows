package varun.dsa.string;

public class PalindromeStringWithBuilder {
    public static void main(String[] args) {

        String string = "helloolleh";
        boolean pal = palindromeString(string);
        System.out.println("Given string is palindrome: " + pal);

    }

    private static boolean palindromeString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        String newString = stringBuilder.reverse().toString();
        return string.equals(newString);
    }
}
