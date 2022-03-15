package varun.dsa.algoexpert.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Same BSTS O ☆
 * An array of integers is said to represent the Binary Search Tree (BST) obtained by inserting each integer in the array,
 * from left to right, into the BST.
 * Write a function that takes in two arrays of integers and determines whether these arrays represent the same BST.
 * Note that you're not allowed to construct any BSTs in your code.
 * A BST is a Binary Tree that consists only of BST nodes. A node is said to be a valid BST node if and only if it satisfies
 * the BST property: its value is strictly greater than the values of every node to its left; its value is less than or
 * equal to the values of every node to its right; and its children nodes are either valid BST nodes themselves or None / null.
 * Sample Input
 * arrayOne = [10, 15, 8, 12, 94, 81, 5, 2, 11)
 * arrayTwo = [10, 8, 5, 15, 2, 12, 11, 94, 81]
 * Sample Output
 * true (Verify by creating BST with both these arrays)
 *
 * Time Complexity: O(n2)
 * Space Complexity: O(n2)
 *
 * Problem Link: https://www.algoexpert.io/questions/Same%20BSTs
 */
public class SameBSTs {

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<>();
        arrayOne.add(10);
        arrayOne.add(15);
        arrayOne.add(8);
        arrayOne.add(12);
        arrayOne.add(94);
        arrayOne.add(81);
        arrayOne.add(5);
        arrayOne.add(2);
        arrayOne.add(11);
        List<Integer> arrayTwo = new ArrayList<>();
        arrayTwo.add(10);
        arrayTwo.add(8);
        arrayTwo.add(5);
        arrayTwo.add(15);
        arrayTwo.add(2);
        arrayTwo.add(12);
        arrayTwo.add(11);
        arrayTwo.add(94);
        arrayTwo.add(81);
        boolean same = sameBsts(arrayOne, arrayTwo);
        System.out.println("Output: " + same);
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if(arrayOne.isEmpty() && arrayTwo.isEmpty()) {
            return true;
        }
        if((arrayOne.size() != arrayTwo.size())) {
            return false;
        }
        if(arrayOne.get(0).intValue()!=arrayTwo.get(0).intValue()) {
            return false;
        }

        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBiggerOrEqual(arrayOne);
        List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);

        return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
    }

    public static List<Integer> getSmaller(List<Integer> array) {
        int firstValue = array.get(0).intValue();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<array.size(); i++) {
            if(array.get(i).intValue()<firstValue) {
                list.add(array.get(i));
            }
        }
        return list;
    }

    public static List<Integer> getBiggerOrEqual(List<Integer> array) {
        int firstValue = array.get(0).intValue();
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<array.size(); i++) {
            if(array.get(i).intValue()>=firstValue) {
                list.add(array.get(i));
            }
        }
        return list;
    }
}
