import interview_questions.trees.TreeNode;

public class Evaluate_boolean_binary_tree {
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0 || root.val == 1) {
            return root.val == 1 ? true : false;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}