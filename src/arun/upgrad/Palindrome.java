package arun.upgrad;


import java.util.Scanner;

class Palindrome {
    public static boolean palindromeWithoutRecursion(int[] num, int index) {
        int size = num.length;
        if (size <= 1) {
            return true;
        }
        boolean isPalindrome = true;
        for (int i = 0; i <= size / 2; i++) {
            if (num[i] != num[size - i - 1]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static boolean palindromeWithRecursion(int[] num, int start, int end) {
        if (num.length <= 1) {
            return true;
        }
        if (num[start] != num[end]) {
            return false;
        }
        if (start >= end) {
            return true;
        }
        return palindromeWithRecursion(num, start + 1, end - 1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[5];
        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
        }
//        boolean answer = palindromeWithoutRecursion(num, 0);
        boolean answer = palindromeWithRecursion(num, 0, num.length - 1);
        System.out.println(answer);
    }
}
