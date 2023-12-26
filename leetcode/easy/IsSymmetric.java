package leetcode.easy;

import leetcode.TreeNode;
import java.util.*;

/*

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 */

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        if (root.left == null && root.right == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<TreeNode> level = new ArrayList<>();

            // Remove the parents of the current level from the queue
            while (!queue.isEmpty()) {
                level.add(queue.poll());
            }

            // Add the children of the current parents (null values are also added) to the queue
            for (TreeNode node: level) {
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }


            // Check if the level is symmetric
            int i = 0;
            int j = level.size() - 1;

            while (i < j) {
                TreeNode first = level.get(i);
                TreeNode second = level.get(j);

                if (first != null && second != null) {
                    if (first.val != second.val) return false;
                } else {
                    if (first != second) return false;
                }

                i++;
                j--;
            }

        }

        // If the while loop concludes and is not interrupted, that means the tree is symmetric
        return true;

    }

}
