package Binary_tree.Conclusion;

import interview_questions.trees.TreeNode;

public class Lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 1. p,q are on 2 sides separately -> root is the lowest common ancestor
        if (left != null && right != null){
            return root;
        }
        // 2. the left node is null, then the p and q must be on the left right side, return the right node
        //  2.1 in the case, left and right are both null, we need to return null for this case.
        //      luckily, right = null so return right still
        if (left == null){
            return right;
        }
        // 3. the right node is null, then the p and q must be on the left side, return the left node
        //  3.1 in the case, left and right are both null, we need to return null for this case.
        //      luckily, left = null so return left still
        if (right == null){
            return left;
        }
        return root;
    }
}
