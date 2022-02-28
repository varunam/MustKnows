package varun.dsa.common.arrays;

import java.util.HashMap;

/**
 * the question is to check if a subarray exists with zero sum
 * <p>
 * solution: https://www.techiedelight.com/check-subarray-with-0-sum-exists-not/
 */
public class SubArrayZeroSum {

    public static void main(String[] args) {

        int[] array = new int[]{1, -6, 3, -1, 4, 2, 7};
        System.out.println(System.currentTimeMillis() + "");
        if (zeroSumArray(array)) {
            System.out.println("Zero sum array exists");
        } else {
            System.out.println("Zero sum array doesn't exist");
        }

    }

    private static boolean zeroSumArray(int[] array) {

        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];

            if (hashMap.containsKey(sum)) {
                return true;
            }

            hashMap.put(sum, sum);

        }

        return false;
    }
}
