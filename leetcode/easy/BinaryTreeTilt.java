package leetcode.easy;

import leetcode.TreeNode;
import java.util.*;

/*

Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values.
If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
The rule is similar if the node does not have a right child.

 */

public class BinaryTreeTilt {

    public int findTilt(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) return 0;

        int tilts = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node);
                tilts = tilts + findSums(node);
            }

            for (TreeNode node: level) {
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

        }

        return tilts;

    }

    private int findSums(TreeNode root) {
        return Math.abs(helper(root.left) - helper(root.right));
    }

    private int helper(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();

        stack.push(root);
        int sum = root.val;

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !visited.contains(node.left)) {
                visited.add(node.left);
                stack.push(node.left);
                sum = sum + node.left.val;
            } else if (node.right != null && !visited.contains(node.right)) {
                visited.add(node.right);
                stack.push(node.right);
                sum = sum + node.right.val;
            } else {
                stack.pop();
            }
        }

        return sum;

    }

}
