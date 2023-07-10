
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Minimum_depth_of_a_binary_tree {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return depth;
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
            }
            depth++;
        }
        return depth;
    }
}
