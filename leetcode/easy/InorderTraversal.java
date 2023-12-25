package leetcode.easy;

import leetcode.TreeNode;

import java.util.*;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> output = new ArrayList<>();

        if (root == null) return output;

        return helper(root, output);

    }

    private List<Integer> helper(TreeNode node, List<Integer> output) {

        if (node.left != null) {
            output = helper(node.left, output);
        }

        output.add(node.val);

        if (node.right != null) {
            output = helper(node.right, output);
        }

        return output;
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {

        List<Integer> output = new ArrayList<>();

        if (root == null) return output;

        Set<TreeNode> checkedLeft = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode value = stack.peek();

            if (value.left != null && !checkedLeft.contains(value)) {
                checkedLeft.add(value);
                stack.push(value.left);
                continue;
            }

            output.add(value.val);
            stack.pop();

            if (value.right != null) {
                stack.push(value.right);
            }
        }

        return output;
    }

}
