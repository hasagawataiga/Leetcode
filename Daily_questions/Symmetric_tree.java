
import interview_questions.trees.TreeNode;

public class Symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTree(root.left, root.right);
    }
    private boolean isSymmetricTree(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
    }
}
