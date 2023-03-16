package Recursion.Recurrence_relation;

import interview_questions.trees.TreeNode;

public class Search_in_a_bianry_search_tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val){
            return root;
        }
        if (root.val < val){
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
