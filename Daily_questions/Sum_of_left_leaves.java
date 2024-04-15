import interview_questions.trees.TreeNode;

public class Sum_of_left_leaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traversal(root, false);
        return sum;
    }
    private void traversal(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && isLeft) {
            sum += node.val;
        }
        traversal(node.left, true);
        traversal(node.right, false);
    }
}
