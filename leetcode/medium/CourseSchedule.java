package leetcode.medium;

import java.util.*;

/*

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first
if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
So it is impossible.

 */

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create a map of value: neighbors
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }

        // Populate the graph according to the info in prerequisites
        for (int[] pair: prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }

        // Perform a depth-first search starting at each node and check for the presence of cycles
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            visited.add(i);

            while (!stack.isEmpty()) {
                int node = stack.peek();
                Set<Integer> neighbors = graph.get(node);

                // Check if one of the neighbors is i (i.e. there is a cycle)
                for (int neighbor: neighbors) {
                    if (neighbor == i) return false;
                }

                boolean shouldPop = true;
                for (int neighbor: neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                        visited.add(neighbor);
                        shouldPop = false;
                        break;
                    }
                }

                if (shouldPop) stack.pop();

            }

        }

        return true;

    }

}
