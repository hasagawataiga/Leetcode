import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cousins_in_binary_tree_ii {
    class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        List<Integer> levelSums = new ArrayList<>();
        int level = 0;
        // Store the level sums of all level
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (level >= levelSums.size()) {
                    levelSums.add(level, temp.val);
                } else {
                    levelSums.set(level, levelSums.get(level) + temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            level++;
        }

        node = root;
        queue.offer(node);
        node.val = 0;
        level = 0;
        // Find the new value of each pair of children by substract the its level sums by those (pair of children in the same branch) sum
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null && temp.right != null) {
                    TreeNode left = temp.left;
                    TreeNode right = temp.right;
                    int sum = left.val + right.val;
                    left.val = levelSums.get(level + 1) - sum;
                    right.val = levelSums.get(level + 1) - sum;
                    queue.offer(left);
                    queue.offer(right);
                } else if (temp.left != null) {
                    temp.left.val = levelSums.get(level + 1) - temp.left.val;
                    queue.offer(temp.left);
                } else if (temp.right != null) {
                    temp.right.val = levelSums.get(level + 1) - temp.right.val;
                    queue.offer(temp.right);
                }
            }
            level++;
        }
        return root;
    }
}
}