package Leetcode_75.Graph_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

import interview_questions.trees.TreeNode;

public class Maximum_level_sum_of_a_binary_tree {
    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        int level = 1;
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
                sum += temp.val;
            }
            if (max < sum){
                max = sum;
                level = count;
            }
            count++;
        }
        return level;
    }
}
