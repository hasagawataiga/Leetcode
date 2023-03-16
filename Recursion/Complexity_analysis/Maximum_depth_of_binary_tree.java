package Recursion.Complexity_analysis;

import interview_questions.trees.TreeNode;

public class Maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    private int maxDepth(TreeNode node, int count){
        if (node == null){
            return count;
        }
        count++;
        int left = maxDepth(node.left, count);
        int right = maxDepth(node.right, count);
        return Math.max(left, right);
    }
}
