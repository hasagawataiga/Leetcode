package interview_questions.trees;

public class Symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        return isTreeSymmetric(root.left, root.right);
    }
    private boolean isTreeSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        // If one of two treenode is null and the other is not, return false
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        // Due to the mirror rule, let compare the left of left node to the right of right node, and otherwise
        return isTreeSymmetric(left.right, right.left) && isTreeSymmetric(left.left, right.right);
    }
}
