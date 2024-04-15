import interview_questions.trees.TreeNode;

public class Sum_root_to_leaf_numbers {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        traversal(root, 0);
        return sum;
    }
    private void traversal(TreeNode node, int value) {
        value *= 10;
        value += node.val;
        if (node.left == null && node.right == null) {
            sum += value;            
            return;
        }
        if (node.left != null) {
            traversal(node.left, value);
        }
        if (node.right != null) {
            traversal(node.right, value);
        }
    }
}
