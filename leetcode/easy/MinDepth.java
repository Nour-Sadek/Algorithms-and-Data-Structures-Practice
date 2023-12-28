package leetcode.easy;

import java.util.*;
import leetcode.TreeNode;

/*

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 */

public class MinDepth {

    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        Stack<TreeNode> nodes = new Stack<>();
        Set<TreeNode> visitedNodes = new HashSet<>();

        nodes.push(root);
        visitedNodes.add(root);
        int minDepth = Integer.MAX_VALUE;
        int depth = 1;


        while (!nodes.isEmpty()) {
            TreeNode node = nodes.peek();

            if (node.left != null && !visitedNodes.contains(node.left)) {
                nodes.push(node.left);
                visitedNodes.add(node.left);
                depth++;
            } else if (node.right != null && !visitedNodes.contains(node.right)) {
                nodes.push(node.right);
                visitedNodes.add(node.right);
                depth++;
            } else if (node.left == null && node.right == null) {
                minDepth = Math.min(minDepth, depth);
                depth--;
                nodes.pop();
            } else {
                nodes.pop();
                depth--;
            }
        }

        return minDepth;

    }

}
