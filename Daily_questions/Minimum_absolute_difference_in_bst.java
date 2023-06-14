import interview_questions.trees.TreeNode;

public class Minimum_absolute_difference_in_bst {
    int min = Integer.MAX_VALUE;
    TreeNode prevNode = null;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }
    // 0: left
    // 1: right
    private void traversal(TreeNode node){
        if (node == null){
            return;
        }
        traversal(node.left);
        if (prevNode != null){
            min = Math.min(min, Math.abs(node.val - prevNode.val));
        }
        prevNode = node;
        traversal(node.right);
    }
}
