package Leetcode_75.Binary_search_tree;

import interview_questions.trees.TreeNode;

public class Search_in_a_binary_search_tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val){
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;
    }
}
