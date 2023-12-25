package leetcode.easy;

import leetcode.TreeNode;

/*

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 */

public class MaxDepth {

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        return helper(root, 1, 1);

    }

    private int helper(TreeNode node, int depth, int maxDepth) {

        if (node != null) {
            maxDepth = Math.max(maxDepth, depth);
            maxDepth = helper(node.left, depth + 1, maxDepth);
            maxDepth = helper(node.right, depth + 1, maxDepth);
        }

        return maxDepth;

    }

}
