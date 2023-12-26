package leetcode.medium;

import leetcode.TreeNode;
import java.util.*;

/*

Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).

 */

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();

        if (root == null) return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> nodesOfLevel = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node.val);
                nodesOfLevel.add(node);
            }

            output.add(level);

            for (TreeNode node: nodesOfLevel) {
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return output;

    }

}
