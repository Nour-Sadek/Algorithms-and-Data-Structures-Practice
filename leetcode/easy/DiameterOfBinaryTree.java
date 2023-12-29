package leetcode.easy;

import java.util.*;
import leetcode.TreeNode;

/*

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 */

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {

        if (root.left == null && root.right == null) return 0;

        List<Integer> diameters = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node);
                diameters.add(findDiameter(node));
            }

            for (TreeNode node: level) {
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

        }

        return Collections.max(diameters);

    }

    private int findDiameter(TreeNode root) {
        return helper(root.left) + helper(root.right);
    }

    private int helper(TreeNode root) {

        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        PriorityQueue<Integer> depths = new PriorityQueue<>(Collections.reverseOrder());

        stack.push(root);
        int depth = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !visited.contains(node.left)) {
                visited.add(node.left);
                stack.push(node.left);
                depth++;
            } else if (node.right != null && !visited.contains(node.right)) {
                visited.add(node.right);
                stack.push(node.right);
                depth++;
            } else if (node.right == null && node.left == null) {
                depths.add(depth);
                stack.pop();
                depth--;
            } else {
                stack.pop();
                depth--;
            }
        }

        return depths.poll() + 1;

    }

}
