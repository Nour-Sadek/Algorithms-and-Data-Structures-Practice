package leetcode.easy;

import leetcode.TreeNode;
import java.util.List;
import java.util.ArrayList;

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

}
