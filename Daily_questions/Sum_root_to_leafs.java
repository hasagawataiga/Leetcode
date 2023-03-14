package Daily_questions;

import interview_questions.trees.TreeNode;

// Use Inorder Traversal
// int sum: store sum value
// int pointer: store the digits of leafs
//  whenever reachs the end of a leaf (both left and right of this node are null)
//  the pointer would be added to sum
public class Sum_root_to_leafs {
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        return preorderTraversal(root, 0, 0);
    }
    private int preorderTraversal(TreeNode node, int sum, int pointer){
        pointer = pointer*10 + node.val;
        if (node.left == null && node.right == null){
            return pointer;
        }
        int left = 0;
        int right = 0;
        if (node.left != null){
            left = preorderTraversal(node.left, sum, pointer);
        }
        if (node.right != null){
            right = preorderTraversal(node.right, sum, pointer);
        }
        return left + right;
    }
}
