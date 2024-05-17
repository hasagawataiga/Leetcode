import interview_questions.trees.TreeNode;

public class Delete_leaves_with_a_given_value {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }
        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
