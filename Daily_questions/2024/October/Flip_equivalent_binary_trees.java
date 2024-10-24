
public class Flip_equivalent_binary_trees {
    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            return isEqual(root1, root2);
        }
        private boolean isEqual(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            } else if (node1 == null || node2 == null) {
                return false;
            } else if (node1.val != node2.val) {
                return false;
            }
            if ((isEqual(node1.left, node2.right) && isEqual(node1.right, node2.left))
            || (isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right))) {
                return true;
            } else {
                return false;
            }
        }
    }
}