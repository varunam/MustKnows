package varun.youtube;

/**
 * Given a range of numbers, count the numbers which have same first and last digits.
 * For ex: Between 7 and 20 such numbers are 8,9 and 11;
 * <p>
 * Solution: https://www.youtube.com/watch?v=bptRLm3OiV8
 */
public class SameFirstAndLastDigits {

    public static void main(String[] args) {
        int first = 6;
        int last = 55;
        int count = findNumbersCountWithSameFirstAndLastDigits(first, last);
        System.out.println("Output: " + count);
    }

    private static int findNumbersCountWithSameFirstAndLastDigits(int first, int last) {
        if (last > 100) {
            return (18 - first) + (last - 100) / 10;
        } else {
            return (9 - first) + last / 11;
        }
    }
}
