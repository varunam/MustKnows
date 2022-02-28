package varun.dsa.arrays;

import varun.stack.StackUsingLinkedList;

/**
 * the problem is that there will be a sequence of buildings with N floors without any gap in between.
 * whenever it rains, water gets accumulated in the empty regions.
 * Problem is to find the number of water units which will be stored when it rains.
 * below is the pictorial representation
 * ______         _______
 * |    |_____    |     |
 * |    |    |    |     |
 * |    |    |____|     |______
 * |    |    |    |     |     |
 * |    |    |    |     |     |
 * <p>
 * for the above building, the answer will be 4 units
 */

public class WaterTrappingArray {

    StackUsingLinkedList stack = new StackUsingLinkedList();

    public static void main(String[] args) {

        int[] buildings = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int result = findWaterCountSpaceOptimised(buildings);//findWaterCount(buildings);
        System.out.println("Result: " + result);
    }


    /**
     * below method is not optimal when space complexity is considered
     *
     * @param buildings
     * @return
     */
    private static int findWaterCount(int[] buildings) {
        int length = buildings.length;

        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int left[] = new int[length];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[length];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = buildings[0];
        for (int i = 1; i < length; i++)
            left[i] = Math.max(left[i - 1], buildings[i]);

        // Fill right array
        right[length - 1] = buildings[length - 1];
        for (int i = length - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], buildings[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < length; i++)
            water += Math.min(left[i], right[i]) - buildings[i];

        return water;
    }

    private static int findWaterCountSpaceOptimised(int[] buildings) {
        int length = buildings.length;
        int result = 0;
        int lo = 0;
        int hi = length - 1;
        int lower_max = 0, higher_max = 0;

        while (lo <= hi) {
            if (buildings[lo] < buildings[hi]) {
                if (buildings[lo] > lower_max) {
                    lower_max = buildings[lo];
                } else {
                    result = result + lower_max - buildings[lo];
                    lo++;
                }
            } else {
                if (buildings[hi] > higher_max) {
                    higher_max = buildings[hi];
                } else {
                    result = result + higher_max - buildings[hi];
                    hi--;
                }
            }
        }
        return result;
    }
}
