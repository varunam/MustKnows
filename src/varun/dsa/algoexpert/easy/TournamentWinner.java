package varun.dsa.algoexpert.easy;

import varun.Utils;

import java.util.HashMap;

/**
 * Tournament Winner
 * There's an algorithms tournament taking place in which teams of programmers compete against each other to solve
 * algorithmic problems as fast as possible. Teams compete in a round robin, where each team faces off against all
 * other teams. Only two teams compete against each other at a time, and for each competition, one team is designated
 * the home team, while the other team is the awa team. In each competition there's always one winner and one loser;
 * there are no ties. A team receives 3 points if it wins and 0 points if it! loses. The winner of the tournament is
 * the team that receives the most amount of points.
 * <p>
 * Given an array of pairs representing the teams that have competed against each other and an array containing the
 * results of each competition, write a function that returns the winner of the tournament. The input arrays are named
 * competitions and results, respectively. The competitions array has elements in the form of [home Team, away Team] ,
 * where each team is a string of at most 30 characters representing the name of the team. The results array contains
 * information about the winner of each corresponding! competition in the competitions array. Specifically, results[i]
 * denotes the winner of competitions[i] , where a 1 in the results array means that the home team in the corresponding
 * competition won and a means that the away team won.
 * <p>
 * It's guaranteed that exactly one team will win the tournament and that each team will compete against all other
 * teams exactly once. It's also guaranteed that the tournament will always have at least two teams.
 * <p>
 * Sample Input: [
 * ["HTML", "C#"],
 * ["C#", "Python"],
 * ["Python", "HTML"]
 * ]
 * results = [0,0,1]
 * Sample Output: Python
 * <p>
 * <p>
 * Time Complexity:
 * O(n) -> Time Complexity where n is the number of competitions.
 * O(k) -> Space complexity where k is the number of teams.
 * <p>
 * Problem Link: https://www.algoexpert.io/questions/Tournament%20Winner
 */
public class TournamentWinner {

    public static void main(String[] args) {
        String[][] input = new String[][]{
                new String[]{"HTML", "C#"},
                new String[]{"C#", "Python"},
                new String[]{"Python", "HTML"},
                new String[]{"Java", "HTML"},
                new String[]{"C#", "HTML"}
        };
        int[] results = new int[]{1, 0, 0, 1, 0};

        System.out.println("<--Input-->");
        Utils.printArray(input);
        Utils.printArray(results);
        String result = getTournamentWinner(input, results);
        System.out.println("");
        System.out.println("<--Output-->");
        System.out.println(result);
    }

    private static String getTournamentWinner(String[][] input, int[] results) {
        HashMap<String, Integer> resultsMap = new HashMap<>();
        int maxValue = 0;
        String maxWinner = "";
        for (int i = 0; i < input.length; i++) {
            String winner;
            if (results[i] == 0) {
                winner = input[i][1];
            } else {
                winner = input[i][0];
            }
            if (resultsMap.containsKey(winner)) {
                int latestValue = resultsMap.get(winner) + 3;
                resultsMap.put(winner, latestValue);
                if (maxValue < latestValue) {
                    maxValue = latestValue;
                    maxWinner = winner;
                }
            } else {
                resultsMap.put(winner, 3);
            }
        }
        System.out.println("Keys: " + resultsMap.keySet());
        System.out.println("Values: " + resultsMap.values());
        return maxWinner;
    }
}
