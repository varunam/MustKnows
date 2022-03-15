package varun.dsa.algoexpert.hard;

import varun.Utils;

import java.util.*;

/**
 * Boggle Board ☆
 * You're given a two-dimensional array (a matrix) of potentially unequal height and width containing letters;
 * this matrix represents a boggle board. You're also given a list of words.
 * Write a function that returns an array of all the words contained in the boggle board. The final words don't need
 * to be in any particular order.
 * A word is constructed in the boggle board by connecting adjacent (horizontally, vertically, or diagonally) letters,
 * without using any single letter at a given position more than once; while a word can of course have repeated letters,
 * those repeated letters must come from different positions in the boggle board in order for the word to be contained
 * in the board. Note that two or more words are allowed to overlap and use the same letters in the boggle board.
 * <p>
 * Sample Input:
 * char[][] boggleBoard = new char[][]{
 * new char[]{'t', 'h', 'i', 's', 'i', 's', 'a'},
 * new char[]{'s', 'i', 'm', 'p', 'l', 'e', 'x'},
 * new char[]{'b', 'x', 'x', 'x', 'x', 'e', 'b'},
 * new char[]{'x', 'o', 'g', 'g', 'l', 'x', 'o'},
 * new char[]{'x', 'x', 'x', 'D', 'T', 'r', 'a'},
 * new char[]{'R', 'E', 'P', 'E', 'A', 'd', 'x'},
 * new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x'},
 * new char[]{'N', 'O', 'T', 'R', 'E', '-', 'P'},
 * new char[]{'x', 'x', 'D', 'E', 'T', 'A', 'E'},
 * };
 * String[] words = new String[]{"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"};
 *
 * Sample Output:
 * [ a boggle this is simple board NOTRE-PEATED ]
 *
 * Time Complexity: O(nm*8^s + ws)
 * Space Complexity: O(nm+ws)
 * n -> width of the board
 * m -> height of the board
 * w -> number of words
 * s -> length of the longeset word.
 *
 * Problem Link: https://www.algoexpert.io/questions/Boggle%20Board
 */
public class BoggleBoard {

    public static void main(String[] args) {
        char[][] boggleBoard = new char[][]{
                new char[]{'t', 'h', 'i', 's', 'i', 's', 'a'},
                new char[]{'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                new char[]{'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                new char[]{'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                new char[]{'x', 'x', 'x', 'D', 'T', 'r', 'a'},
                new char[]{'R', 'E', 'P', 'E', 'A', 'd', 'x'},
                new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                new char[]{'N', 'O', 'T', 'R', 'E', '-', 'P'},
                new char[]{'x', 'x', 'D', 'E', 'T', 'A', 'E'},
        };
        String[] words = new String[]{"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"};
        List<String> list = boggleBoard(boggleBoard, words);
        Utils.print(list);
    }

    public static List<String> boggleBoard(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        Set<String> finalWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                explore(i, j, board, trie.root, visited, finalWords);
            }
        }

        List<String> finalWordsArray = new ArrayList<>();
        finalWordsArray.addAll(finalWords);
        return finalWordsArray;
    }

    public static void explore(int i, int j, char[][] board, TrieNode trieNode,
                               boolean[][] visited, Set<String> finalWords) {
        if (visited[i][j]) {
            return;
        }

        char letter = board[i][j];
        if (!trieNode.children.containsKey(letter)) {
            return;
        }

        visited[i][j] = true;
        trieNode = trieNode.children.get(letter);
        if (trieNode.children.containsKey('*')) {
            finalWords.add(trieNode.word);
        }

        List<Integer[]> neighbours = getNeighbours(i, j, board);
        for (Integer[] neighbour : neighbours) {
            explore(neighbour[0], neighbour[1], board, trieNode, visited, finalWords);
        }
        visited[i][j] = false;
    }

    public static List<Integer[]> getNeighbours(int i, int j, char[][] board) {
        List<Integer[]> neighbours = new ArrayList<>();

        if (i > 0 && j > 0) {
            neighbours.add(new Integer[]{i - 1, j - 1});
        }

        if (i > 0 && j < board[0].length - 1) {
            neighbours.add(new Integer[]{i - 1, j + 1});
        }

        if (i < board.length - 1 && j < board[0].length - 1) {
            neighbours.add(new Integer[]{i + 1, j + 1});
        }

        if (i < board.length - 1 && j > 0) {
            neighbours.add(new Integer[]{i + 1, j - 1});
        }

        if (i > 0) {
            neighbours.add(new Integer[]{i - 1, j});
        }

        if (i < board.length - 1) {
            neighbours.add(new Integer[]{i + 1, j});
        }

        if (j > 0) {
            neighbours.add(new Integer[]{i, j - 1});
        }

        if (j < board[0].length - 1) {
            neighbours.add(new Integer[]{i, j + 1});
        }

        return neighbours;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = "";
    }

    public static class Trie {
        TrieNode root;
        char endSymbol;

        public Trie() {
            this.root = new TrieNode();
            this.endSymbol = '*';
        }

        public void add(String string) {
            TrieNode node = this.root;
            for (int i = 0; i < string.length(); i++) {
                char letter = string.charAt(i);
                if (!node.children.containsKey(letter)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                }
                node = node.children.get(letter);
            }
            node.children.put(this.endSymbol, null);
            node.word = string;
        }
    }
}
