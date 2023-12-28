package leetcode.easy;

import leetcode.TreeNode;

/*

Given a binary tree, determine if it is height-balanced.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 */

public class BalancedTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (Math.abs(helper(root.left, 0, 0) - helper(root.right, 0, 0)) > 1) return false;
        if (!isBalanced(root.left)) return false;
        return isBalanced(root.right);

    }

    private int helper(TreeNode node, int depth, int maxDepth) {

        maxDepth = Math.max(depth, maxDepth);

        if (node != null) {
            maxDepth = helper(node.left, depth + 1, maxDepth);
            maxDepth = helper(node.right, depth + 1, maxDepth);
        }

        return maxDepth;
    }

}
