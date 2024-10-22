import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Kth_largest_sum_in_a_binary_tree {

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

    class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {
            Map<Integer, Long> map = new HashMap<>();
            traversal(root, map, 0);
            int size = map.size();
            if (size < k) {
                return -1;
            }
            long[] levelSums = new long[size];
            for (int i = 0; i < size; i++) {
                levelSums[i] = map.get(i);
            }
            Arrays.sort(levelSums);
            return levelSums[size - k];
        }

        private void traversal(TreeNode node, Map<Integer, Long> map, int level) {
            if (node == null) {
                return;
            }
            map.putIfAbsent(level, 0l);
            map.put(level, map.get(level) + node.val);
            traversal(node.left, map, level + 1);
            traversal(node.right, map, level + 1);
        }
    }
}