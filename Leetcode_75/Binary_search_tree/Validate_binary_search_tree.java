package Leetcode_75.Binary_search_tree;

import interview_questions.trees.TreeNode;

// Use Long.MIN_VALUE and Long.MAX_VALUE to ignore the case node.val = Integer.MAX_VALUE / Integer.MIN_VALUE
//      cause the algorithm broken
public class Validate_binary_search_tree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node, long min, long max){
        if (node.val <= min || node.val >= max){
            return false;
        }
        boolean left = true;
        boolean right = true;
        if (node.left != null){
            left = isValidBST(node.left, min, node.val);
        }
        if (node.right != null){
            right = isValidBST(node.right, node.val, max);
        }
        return left && right;
    }
}
