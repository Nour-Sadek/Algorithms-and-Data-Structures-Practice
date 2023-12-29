package leetcode.medium;

import leetcode.TreeNode;
import java.util.*;

/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 */

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q) return root;

        TreeNode node = findNextNode(root, p, q);

        if (node == root) return root;
        else return lowestCommonAncestor(node, p, q);

    }

    private TreeNode findNextNode(TreeNode root, TreeNode p, TreeNode q) {
        boolean left = root.left != null && helper(root.left, p, q);
        boolean right = root.right != null && helper(root.right, p, q);

        if (left && right) return root;
        else return right ? root.right : root.left;
    }

    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {

        if (node == p || node == q) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Set<TreeNode> level = new HashSet<>();

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (curr == p || curr == q) return true;
                level.add(curr);
            }

            for (TreeNode curr: level) {
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return false;
    }

}
