package varun.dsa.algoexpert.medium;

import varun.Utils;

import java.util.Arrays;

/**
 * Cycle In Graph
 * You're given a list of edges representing an unweighted, directed graph with at least one node. Write a function
 * that returns a boolean representing whether the given graph contains a cycle,
 * For the purpose of this question, a cycle is defined as any number of vertices, including just one vertex, that are
 * connected in a closed chain. A cycle can also be defined as a chain of at least one vertex in which the first vertex
 * is the same as the last,
 * The given list is what's called an adjacency list, and it represents a graph. The number of vertices in the graph is
 * equal to the length of edges , where each index i in edges contains vertex i 's outbound edges, in no particular order.
 * Each individual edge is represented by a positive integer that denotes an index (a destination vertex) in the list
 * that this vertex is connected to. Note that these edges are directed, meaning that you can only travel from a particular
 * vertex to its destination, not the other way around (unless the destination vertex itself has an outbound edge to the original vertex).
 * Also note that this graph may contain self-loops. A self-loop is an edge that has the same destination and origin;
 * in other words, it's an edge that connects a vertex to itself. For the purpose of this question, a self-loop is considered a cycle.
 * For a more detailed explanation, please refer to the Conceptual Overview section of this question's video explanation.
 *
 * Time Complexity -> O(v + e)
 * Space Complexity -> O(v)
 * V is the number of vertices and e is the number of edges.
 *
 * Problem Link: https://www.algoexpert.io/questions/Cycle%20In%20Graph
 */
public class CycleInGraph {

    /**
     * Indicates that the node is neither visited nor in the stack.
     */
    private static int WHITE = 0;
    /**
     * Indicates that the node is visited.
     */
    private static int GREY = 1;
    /**
     * Indicates that the node is visited but not in stack.
     */
    private static int BLACK = 2;

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                new int[]{1, 3},
                new int[]{2, 3, 4},
                new int[]{0},
                new int[]{},
                new int[]{2, 5},
                new int[]{}
        };
        System.out.println("<--Input-->");
        Utils.print(edges);
        System.out.println("<--Output-->");
        boolean result = containsCycle(edges);
        System.out.println("Contains Cycle: " + result);
    }

    public static boolean containsCycle(int[][] edges) {
        int numberOfNodes = edges.length;
        int[] colors = new int[numberOfNodes];
        Arrays.fill(colors, WHITE);

        for (int node = 0; node < numberOfNodes; node++) {
            if (colors[node] != WHITE) {
                continue;
            }

            boolean containsCycle = containsCycle(edges, node, colors);
            if (containsCycle) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsCycle(int[][] edges, int node, int[] colors) {
        colors[node] = GREY;

        int[] neighbours = edges[node];
        for (int neighbour : neighbours) {
            int neighbourColor = colors[neighbour];

            if (neighbourColor == GREY) {
                return true;
            }

            if (neighbour == BLACK) {
                continue;
            }

            boolean containsCycle = containsCycle(edges, neighbour, colors);
            if (containsCycle) {
                return true;
            }
        }

        colors[node] = BLACK;
        return false;
    }
}
