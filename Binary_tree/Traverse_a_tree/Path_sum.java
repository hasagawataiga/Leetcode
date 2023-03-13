package Binary_tree.Traverse_a_tree;

import interview_questions.trees.TreeNode;

// Using Inorder Traversal
public class Path_sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null && (targetSum - root.val) == 0){
            return true;
        }
        if (root.left == null && root.right == null && (targetSum - root.val) != 0){
            return false;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
