package leetcode.medium;

import leetcode.TreeNode;
import java.util.List;
import java.util.ArrayList;

/*
Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node.
A leaf is a node with no children.

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Example 2:

Input: root = [1,2,3], targetSum = 5
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

 */

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> output = new ArrayList<>();

        if (root == null) return output;

        List<TreeNode> stackNodes = new ArrayList<>();
        TreeNode curr = root;
        stackNodes.add(curr);

        List<TreeNode> visited = new ArrayList<>();
        visited.add(curr);

        while (!stackNodes.isEmpty()) {
            if (curr.left != null && !visited.contains(curr.left)) {  // Check left TreeNode

                stackNodes.add(curr.left);
                visited.add(curr.left);
                curr = curr.left;

            } else if (curr.right != null && !visited.contains(curr.right)) {  // Check right TreeNode

                stackNodes.add(curr.right);
                visited.add(curr.right);
                curr = curr.right;

            } else if (curr.left == null && curr.right == null) {  // A leaf node is reached

                int totalSum = 0;

                // Determine total sum of this path
                List<Integer> stack = new ArrayList<>();
                for (TreeNode node: stackNodes) {
                    totalSum += node.val;
                    stack.add(node.val);
                }

                // Compare to target sum and add to output if equal
                if (totalSum == targetSum) {
                    output.add(stack);
                }

                // Remove leaf node from stack
                stackNodes.remove(stackNodes.size() - 1);

                if (!stackNodes.isEmpty()) {
                    curr = stackNodes.get(stackNodes.size() - 1);
                }

            } else {
                stackNodes.remove(stackNodes.size() - 1);

                if (!stackNodes.isEmpty()) {
                    curr = stackNodes.get(stackNodes.size() - 1);
                }
            }

        }

        return output;

    }

    // Recursive implementation of the required function
    public List<List<Integer>> pathSumRecursive(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        if (root == null) return output;

        return helper(root, targetSum, 0, path, output);
    }

    private List<List<Integer>> helper(TreeNode node, int targetSum, int pathSum, List<Integer> path, List<List<Integer>> output) {

        List<Integer> temp = path;
        path = new ArrayList<>();

        for (int num: temp) {
            path.add(num);
        }

        path.add(node.val);
        pathSum += node.val;

        if (node.left == null && node.right == null) {
            if (pathSum == targetSum) {
                output.add(path);
            }
        } else {
            if (node.left != null) {
                output = helper(node.left, targetSum, pathSum, path, output);
            }

            if (node.right != null) {
                output = helper(node.right, targetSum, pathSum, path, output);
            }

        }

        return output;
    }

}
