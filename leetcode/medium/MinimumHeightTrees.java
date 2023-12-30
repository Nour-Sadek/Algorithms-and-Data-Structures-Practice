package leetcode.medium;

import java.util.*;

/*

A tree is an undirected graph in which any two vertices are connected by exactly one path.
In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi]
indicates that there is an undirected edge between the two nodes ai and bi in the tree,
you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h.
Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

Example 1:

Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]

Example 2:

Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]

 */

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> roots = new ArrayList<>();

        // First edge case: the tree contains only one node
        if (n ==  1) {
            roots.add(0);
            return roots;
        }

        // Second edge case: the tree contains only two nodes
        if (n == 2) {
            roots.add(0);
            roots.add(1);
            return roots;
        }

        // Determine the nodes that are not leaves (a node is a leaf if it only appears in one edge)
        Set<Integer> notLeaves = new HashSet<>();
        int[] counts = new int[n];
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // All nodes are not leaves until proven otherwise :)
            notLeaves.add(i);
            graph.add(new HashSet<>());
        }

        for (int[] edge: edges) {
            counts[edge[0]] = counts[edge[0]] + 1;
            counts[edge[1]] = counts[edge[1]] + 1;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (counts[i] == 1) notLeaves.remove(i);
        }

        // perform depth-first search from all nodes that are not leaves and determine the MHT for each
        int minHeight = Integer.MAX_VALUE;
        Map<Integer, Integer> mhtOfNodes = new HashMap<>();

        for (int node: notLeaves) {
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(node);
            visited.add(node);

            int count = 0;
            int maxCount = Integer.MIN_VALUE;

            while (!stack.isEmpty()) {
                int curr = stack.peek();

                if (!notLeaves.contains(curr)) {
                    maxCount = Math.max(maxCount, count);
                    stack.pop();
                    count--;
                    continue;
                }

                boolean shouldPop = true;
                for (int neighbor: graph.get(curr)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        stack.push(neighbor);
                        count++;
                        shouldPop = false;
                        break;
                    }
                }

                if (shouldPop) {
                    stack.pop();
                    count--;
                }

            }

            minHeight = Math.min(minHeight, maxCount);
            mhtOfNodes.put(node, maxCount);

        }

        // Find the nodes whose personal MHT is the same as the true MHT of the tree
        for (int node: notLeaves) {
            if (mhtOfNodes.get(node) == minHeight) roots.add(node);
        }

        return roots;

    }

}
