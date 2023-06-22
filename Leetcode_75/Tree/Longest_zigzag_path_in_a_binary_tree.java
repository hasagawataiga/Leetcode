package Leetcode_75.Tree;

import interview_questions.trees.TreeNode;

public class Longest_zigzag_path_in_a_binary_tree {
    public int longestZigZag(TreeNode root) {
        int rightLength = longestZigZag(root.right, false, 0);
        int leftLength = longestZigZag(root.left, true, 0);
        return Math.max(rightLength, leftLength);
    }
    private int longestZigZag(TreeNode node, boolean isRight, int length){
        if (node == null){
            return length;
        }
        int max = length;
        int rightFlow = 0;
        int leftFlow = 0;
        int rightNonFlow = 0;
        int leftNonFlow = 0;
        if (isRight){
            rightFlow = longestZigZag(node.right, false, length + 1);
            leftNonFlow = longestZigZag(node.left, true, 0);
            max = Math.max(rightFlow, leftNonFlow);
        } else {
            leftFlow = longestZigZag(node.left, true, length + 1);
            rightNonFlow = longestZigZag(node.right, false, 0);
            max = Math.max(rightNonFlow, leftFlow);
        }
        return max;
    }
}
