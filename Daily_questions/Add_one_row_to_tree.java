package Daily_questions;

import interview_questions.trees.TreeNode;

public class Add_one_row_to_tree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val, root, null);
            return node;
        }
        traversal(root, depth, val);
        return root;
    }
    private void traversal(TreeNode node, int depth, int val) {
        if (node == null) {
            return;
        }
        if (depth == 2) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            TreeNode targetLeft = new TreeNode(val, left, null);
            TreeNode targetRight = new TreeNode(val, null, right);
            node.left = targetLeft;
            node.right = targetRight;
            return;
        }
        traversal(node.left, depth - 1, val);
        traversal(node.right, depth - 1, val);
    }
}
