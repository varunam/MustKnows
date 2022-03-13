package varun.dsa.algoexpert.medium;

import java.util.*;

/**
 * Group Anagrams
 * Write a function that takes in an array of strings and groups anagrams together.
 * Anagrams are strings made up of exactly the same letters, where order doesn't matter.
 * For example, "cinema" and "iceman" are anagrams; similarly, "foo" and "ofo" are anagrams.
 * Your function should return a list of anagram groups in no particular order.
 * Sample Input
 * words = ["yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")
 * Sample Output
 * [["yo", "oy"], ["flop", "olfp"], ["act", "tac", "cat"], ["foo"]]
 * <p>
 * Time Complexity: O(W*n*logn)
 * Space Complexity: O(wn)
 * where w is the number of words and n is the length of longest word.
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Group%20Anagrams
 */
public class GroupAnagram {

    public static void main(String[] args) {
        List<String> listOfString = new ArrayList<>();
        listOfString.add("yo");
        listOfString.add("act");
        listOfString.add("flop");
        listOfString.add("tac");
        listOfString.add("foo");
        listOfString.add("cat");
        listOfString.add("oy");
        listOfString.add("olfp");

        /*List<String> listOfString = new ArrayList<>();
        listOfString.add("ill");
        listOfString.add("duh");*/

        List<List<String>> result = new ArrayList<>(groupAnagramsBestSolution(listOfString));
        System.out.println("Found anagrams: " + result.size());
    }

    //This solution works absolutely fine but not when string sum gets equal by chance. For example:
    //sum of "duh" and "ill" are same and this messes up the solution. Hence refer to the other solution.
    public static Collection<List<String>> groupAnagrams(List<String> words) {
        HashMap<Integer, List<String>> stringMap = new HashMap<>();
        for (String word : words) {
            int sum = getStringSum(word);
            if (stringMap.containsKey(sum)) {
                stringMap.get(sum).add(word);
                continue;
            }
            stringMap.put(getStringSum(word), new ArrayList<>(Collections.singleton(word)));
        }
        return stringMap.values();
    }

    public static int getStringSum(String string) {
        int length = string.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + string.charAt(i);
        }
        return sum;
    }

    public static List<List<String>> groupAnagramsBestSolution(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
            }
        }
        return new ArrayList<>(anagrams.values());
    }
}
