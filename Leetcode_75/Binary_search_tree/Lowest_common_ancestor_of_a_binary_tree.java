package Leetcode_75.Binary_search_tree;

import interview_questions.trees.TreeNode;

public class Lowest_common_ancestor_of_a_binary_tree{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }
}