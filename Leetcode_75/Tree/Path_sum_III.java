package Leetcode_75.Tree;

import interview_questions.trees.TreeNode;

public class Path_sum_III {
    int count = 0;
    int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        this.targetSum = targetSum;
        traversal(root);
        return count;
    }
    private void traversal(TreeNode node){
        if (node == null){
            return;
        }
        dfs(node, 0L);
        traversal(node.left);
        traversal(node.right);
    }
    private void dfs(TreeNode node, long sum){
        if (node == null){
            return;
        }
        if (sum + node.val == targetSum){
            count++;
        }
        dfs(node.left, sum + node.val);
        dfs(node.right, sum + node.val);
    }
}
