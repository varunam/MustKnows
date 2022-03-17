package varun.dsa.algoexpert.hard;

import varun.Utils;

import java.util.ArrayList;
import java.util.List;

public class MinimumSumIncreasingSequence {

    public static void main(String[] args) {
        //int[] input = new int[]{10, 70, 20, 30, 50, 11, 35};
        int[] input = new int[]{-1,1};
        List<List<Integer>> output = maxSumIncreasingSubsequence(input);
        for(List<Integer> list: output) {
            Utils.print(list);
        }
    }

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        List<Integer> list = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        int sum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (list.isEmpty()) {
                list.add(array[i]);
                sum = array[i];
            } else {
                int latestValue = list.get(list.size() - 1);
                int currentValue = array[i];
                if (currentValue > latestValue) {
                    list.add(currentValue);
                    sum += currentValue;
                } else {
                    while (list.get(list.size() - 1) > currentValue) {
                        list.remove(list.size() - 1);
                    }
                    sum = 0;
                    for (int value : list) {
                        sum += value;
                    }
                    sum += currentValue;
                    list.add(currentValue);
                }
            }
            if(sum > maxSum) {
                maxSum = sum;
                maxList = new ArrayList<>(list);
            }
        }
        final int resultSum = maxSum;
        final List<Integer> resultList = maxList;
        return new ArrayList<List<Integer>>() {
            {
                add(List.of(resultSum)); // Example max sum
                add(resultList); // Example max sequence
            }
        };
    }
}
