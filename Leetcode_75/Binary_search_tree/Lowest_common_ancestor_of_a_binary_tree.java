package Leetcode_75.Binary_search_tree;

import interview_questions.trees.TreeNode;

public class Lowest_common_ancestor_of_a_binary_tree{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}