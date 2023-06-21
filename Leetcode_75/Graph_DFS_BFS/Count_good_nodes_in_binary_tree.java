package Leetcode_75.Graph_DFS_BFS;

import interview_questions.trees.TreeNode;

public class Count_good_nodes_in_binary_tree {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }
    private void dfs(TreeNode node, int max){
        if (node == null){
            return;
        }
        if (node.val >= max){
            count++;
            max = node.val;
        }
        if (node.left != null){
            dfs(node.left, max);
        }
        if (node.right != null){
            dfs(node.right, max);
        }
    }
}
