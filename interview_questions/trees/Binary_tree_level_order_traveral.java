package interview_questions.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_level_order_traveral {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return res;
        }
        queue.add(root);
        // Using BFS
        while (!queue.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++){
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }
}
