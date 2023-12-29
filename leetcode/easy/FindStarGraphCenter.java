package leetcode.easy;

import java.util.Map;
import java.util.HashMap;

/*

There is an undirected star graph consisting of n nodes labeled from 1 to n.
A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi.
Return the center of the given star graph.

Example 1:

Input: edges = [[1,2],[2,3],[4,2]]
Output: 2

Example 2:

Input: edges = [[1,2],[5,1],[1,3],[1,4]]
Output: 1

 */

public class FindStarGraphCenter {

    public int findCenter(int[][] edges) {

        // Initiate a map where the keys are the nodes and the values are the number of connections these node have with other nodes
        Map<Integer, Integer> numConnections = new HashMap<>();
        for (int i = 1; i <= edges.length + 1; i++) {
            numConnections.put(i, 0);
        }

        // Update the map where the value increases by one for each connection
        for (int[] pair: edges) {
            numConnections.put(pair[0], numConnections.get(pair[0]) + 1);
            numConnections.put(pair[1], numConnections.get(pair[1]) + 1);
        }

        // Return the node that has n - 1 connections
        int center = -1;
        for (int i = 1; i <= numConnections.size(); i++) {
            if (numConnections.get(i) == edges.length) {
                center = i;
                return i;
            }
        }

        return center;

    }

}
