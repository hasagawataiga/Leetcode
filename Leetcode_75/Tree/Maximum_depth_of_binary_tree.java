package Leetcode_75.Tree;

import interview_questions.trees.TreeNode;

public class Maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode node){
        if (node == null){
            return 0;
        }
        int count = 0;
        if (node.left != null){
            count = Math.max(dfs(node.left), count);
        }
        if (node.right != null){
            count = Math.max(dfs(node.right), count);
        }
        return count + 1;
    }
}
