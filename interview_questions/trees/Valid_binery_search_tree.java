package interview_questions.trees;

public class Valid_binery_search_tree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    // Using the current root value to set to the max and min value instead of using MAX_VALUE/MIN_VALUE (of Integer, Long, Double, ...)
    // In this case, the init value of min and max would be null, then the parameters in the second isValidBST should be Integer not int
    //  because int typt can not takes the null value
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        // The traversing will return false as soon as any node is not a valid BST
        //  if the traverse could reached the end of tree, it must be true
        if (node == null) {
            return true;
        }
        // Check the value of node with the max and min
        // If the min value is not null, the root is checked should be on the right side.
        // then return false if the value is less than or equal min (BST rules)
        // otherwise with the left side
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
